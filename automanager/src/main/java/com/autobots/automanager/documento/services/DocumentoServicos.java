package com.autobots.automanager.documento.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.autobots.automanager.documento.entities.Documento;
import com.autobots.automanager.documento.repositories.DocumentoRepositorio;

@Service
public class DocumentoServicos {

    private final DocumentoRepositorio repositorio;

    public DocumentoServicos(DocumentoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Documento> obterDocumentos() {
        return repositorio.findAll();
    }

    public Documento obterDocumento(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public void cadastrarDocumento(Documento documento) {
        repositorio.save(documento);
    }

    public void atualizarDocumento(Documento atualizacao) {
        Documento documento = obterDocumento(atualizacao.getId());

        if (documento != null) {
            documento.setTipo(atualizacao.getTipo());
            documento.setNumero(atualizacao.getNumero());

            repositorio.save(documento);
        }
    }

    public void excluirDocumento(long id) {
        Documento documento = obterDocumento(id);

        if (documento != null) {
            repositorio.delete(documento);
        }
    }
}