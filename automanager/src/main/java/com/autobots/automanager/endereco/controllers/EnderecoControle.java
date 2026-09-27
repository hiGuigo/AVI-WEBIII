package com.autobots.automanager.endereco.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.endereco.entities.Endereco;
import com.autobots.automanager.endereco.services.EnderecoServicos;

@RestController
@RequestMapping("/enderecos")
public class EnderecoControle {

    private final EnderecoServicos servicos;

    public EnderecoControle(EnderecoServicos servicos) {
        this.servicos = servicos;
    }

    @GetMapping
    public List<Endereco> obterEnderecos() {
        return servicos.obterEnderecos();
    }

    @GetMapping("/{id}")
    public Endereco obterEndereco(@PathVariable long id) {
        return servicos.obterEndereco(id);
    }

    @PostMapping
    public void cadastrarEndereco(@RequestBody Endereco endereco) {
        servicos.cadastrarEndereco(endereco);
    }

    @PutMapping("/{id}")
    public void atualizarEndereco(
        @PathVariable long id,
        @RequestBody Endereco atualizacao
    ) {
        servicos.atualizarEndereco(id, atualizacao);
    }

    @DeleteMapping("/{id}")
    public void excluirEndereco(@PathVariable long id) {
        servicos.excluirEndereco(id);
    }
}