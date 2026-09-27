package com.autobots.automanager.endereco.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.autobots.automanager.endereco.entities.Endereco;
import com.autobots.automanager.endereco.repositories.EnderecoRepositorio;

@Service
public class EnderecoServicos {

    private final EnderecoRepositorio repositorio;

    public EnderecoServicos(EnderecoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Endereco> obterEnderecos() {
        return repositorio.findAll();
    }

    public Endereco obterEndereco(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public void cadastrarEndereco(Endereco endereco) {
        repositorio.save(endereco);
    }

    public void atualizarEndereco(long id, Endereco atualizacao) {
        Endereco endereco = obterEndereco(id);

        if (endereco != null) {
            endereco.setEstado(atualizacao.getEstado());
            endereco.setCidade(atualizacao.getCidade());
            endereco.setBairro(atualizacao.getBairro());
            endereco.setRua(atualizacao.getRua());
            endereco.setNumero(atualizacao.getNumero());
            endereco.setCodigoPostal(atualizacao.getCodigoPostal());
            endereco.setInformacoesAdicionais(
                atualizacao.getInformacoesAdicionais()
            );

            repositorio.save(endereco);
        }
    }

    public void excluirEndereco(long id) {
        Endereco endereco = obterEndereco(id);

        if (endereco != null) {
            repositorio.delete(endereco);
        }
    }
}