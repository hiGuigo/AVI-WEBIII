package com.autobots.automanager.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ApiError> tratarRecursoNaoEncontrado(
        RecursoNaoEncontradoException exception, HttpServletRequest request
    ) {
        return criarResposta(HttpStatus.NOT_FOUND, exception.getMessage(), request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> tratarValidacao(
        MethodArgumentNotValidException exception, HttpServletRequest request
    ) {
        String mensagem = exception.getBindingResult().getFieldErrors().stream()
            .map(erro -> erro.getField() + ": " + erro.getDefaultMessage())
            .findFirst()
            .orElse("Os dados enviados são inválidos.");
        return criarResposta(HttpStatus.BAD_REQUEST, mensagem, request);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> tratarJsonInvalido(
        HttpMessageNotReadableException exception, HttpServletRequest request
    ) {
        return criarResposta(HttpStatus.BAD_REQUEST, "O corpo da requisição está ausente ou malformado.", request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> tratarErroInterno(
        Exception exception, HttpServletRequest request
    ) {
        LOGGER.error("Erro não tratado durante a requisição {}", request.getRequestURI(), exception);
        return criarResposta(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "Ocorreu um erro interno. Tente novamente mais tarde.",
            request
        );
    }

    private ResponseEntity<ApiError> criarResposta(
        HttpStatus status, String mensagem, HttpServletRequest request
    ) {
        ApiError erro = new ApiError(
            status.value(), status.getReasonPhrase(), mensagem, request.getRequestURI()
        );
        return ResponseEntity.status(status).body(erro);
    }
}
