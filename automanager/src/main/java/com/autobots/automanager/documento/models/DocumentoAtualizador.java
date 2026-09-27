package com.autobots.automanager.documento.models;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.documento.entities.Documento;
import com.autobots.automanager.utils.StringVerificadorNulo;

@Component
public class DocumentoAtualizador {

    private final StringVerificadorNulo verificador;

    public DocumentoAtualizador(StringVerificadorNulo verificador) {
        this.verificador = verificador;
    }

    public void atualizar(Documento documento, Documento atualizacao) {

        if (atualizacao != null) {

            if (!verificador.verificar(atualizacao.getTipo())) {
                documento.setTipo(atualizacao.getTipo());
            }

            if (!verificador.verificar(atualizacao.getNumero())) {
                documento.setNumero(atualizacao.getNumero());
            }
        }
    }

    public void atualizar(
        List<Documento> documentos,
        List<Documento> atualizacoes
    ) {
        for (Documento atualizacao : atualizacoes) {

            for (Documento documento : documentos) {

                if (atualizacao.getId() != null &&
                    atualizacao.getId().equals(documento.getId())) {

                    atualizar(documento, atualizacao);
                }
            }
        }
    }
}