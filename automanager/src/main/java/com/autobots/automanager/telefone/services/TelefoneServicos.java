package com.autobots.automanager.telefone.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.autobots.automanager.telefone.entities.Telefone;
import com.autobots.automanager.telefone.repositories.TelefoneRepositorio;

@Service
public class TelefoneServicos {

    private final TelefoneRepositorio repositorio;

    public TelefoneServicos(TelefoneRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Telefone> obterTelefones() {
        return repositorio.findAll();
    }

    public Telefone obterTelefone(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public void cadastrarTelefone(Telefone telefone) {
        repositorio.save(telefone);
    }

    public void atualizarTelefone(long id, Telefone atualizacao) {
        Telefone telefone = obterTelefone(id);

        if (telefone != null) {
            telefone.setDdd(atualizacao.getDdd());
            telefone.setNumero(atualizacao.getNumero());

            repositorio.save(telefone);
        }
    }

    public void excluirTelefone(long id) {
        Telefone telefone = obterTelefone(id);

        if (telefone != null) {
            repositorio.delete(telefone);
        }
    }
}