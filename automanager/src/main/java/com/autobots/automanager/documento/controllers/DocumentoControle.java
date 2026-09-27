package com.autobots.automanager.documento.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.documento.entities.Documento;
import com.autobots.automanager.documento.services.DocumentoServicos;

@RestController
@RequestMapping("/documentos")
public class DocumentoControle {

    private final DocumentoServicos servicos;

    public DocumentoControle(DocumentoServicos servicos) {
        this.servicos = servicos;
    }

    @GetMapping
    public List<Documento> obterDocumentos() {
        return servicos.obterDocumentos();
    }

    @GetMapping("/{id}")
    public Documento obterDocumento(@PathVariable long id) {
        return servicos.obterDocumento(id);
    }

    @PostMapping
    public void cadastrarDocumento(@RequestBody Documento documento) {
        servicos.cadastrarDocumento(documento);
    }

    @PutMapping
    public void atualizarDocumento(@RequestBody Documento atualizacao) {
        servicos.atualizarDocumento(atualizacao);
    }

    @DeleteMapping("/{id}")
    public void excluirDocumento(@PathVariable long id) {
        servicos.excluirDocumento(id);
    }
}