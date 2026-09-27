package com.autobots.automanager.telefone.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.telefone.entities.Telefone;
import com.autobots.automanager.telefone.services.TelefoneServicos;

@RestController
@RequestMapping("/telefones")
public class TelefoneControle {

    private final TelefoneServicos servicos;

    public TelefoneControle(TelefoneServicos servicos) {
        this.servicos = servicos;
    }

    @GetMapping
    public List<Telefone> obterTelefones() {
        return servicos.obterTelefones();
    }

    @GetMapping("/{id}")
    public Telefone obterTelefone(@PathVariable long id) {
        return servicos.obterTelefone(id);
    }

    @PostMapping
    public void cadastrarTelefone(@RequestBody Telefone telefone) {
        servicos.cadastrarTelefone(telefone);
    }

    @PutMapping("/{id}")
    public void atualizarTelefone(
        @PathVariable long id,
        @RequestBody Telefone atualizacao
    ) {
        servicos.atualizarTelefone(id, atualizacao);
    }

    @DeleteMapping("/{id}")
    public void excluirTelefone(@PathVariable long id) {
        servicos.excluirTelefone(id);
    }
}