package com.autobots.automanager.cliente.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.cliente.entities.Cliente;
import com.autobots.automanager.cliente.services.ClienteServicos;

@RestController
@RequestMapping("/clientes")
public class ClienteControle {

    private final ClienteServicos servicos;

    public ClienteControle(ClienteServicos servicos) {
        this.servicos = servicos;
    }

    @GetMapping
    public List<Cliente> obterClientes() {
        return servicos.obterClientes();
    }

    @GetMapping("/{id}")
    public Cliente obterCliente(@PathVariable long id) {
        return servicos.obterCliente(id);
    }

    @PostMapping
    public void cadastrarCliente(@RequestBody Cliente cliente) {
        servicos.cadastrarCliente(cliente);
    }

    @PutMapping
    public void atualizarCliente(@RequestBody Cliente atualizacao) {
        servicos.atualizarCliente(atualizacao);
    }

    @DeleteMapping
    public void excluirCliente(@RequestBody Cliente exclusao) {
        servicos.excluirCliente(exclusao);
    }
}