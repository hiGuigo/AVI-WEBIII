package com.autobots.automanager.cliente.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.autobots.automanager.cliente.entities.Cliente;
import com.autobots.automanager.cliente.models.ClienteAtualizador;
import com.autobots.automanager.cliente.models.ClienteSelecionador;
import com.autobots.automanager.cliente.repositories.ClienteRepositorio;

@Service
public class ClienteServicos {

    private final ClienteRepositorio repositorio;
    private final ClienteSelecionador selecionador;
    private final ClienteAtualizador atualizador;

    public ClienteServicos(
        ClienteRepositorio repositorio,
        ClienteSelecionador selecionador,
        ClienteAtualizador atualizador
    ) {
        this.repositorio = repositorio;
        this.selecionador = selecionador;
        this.atualizador = atualizador;
    }

    public List<Cliente> obterClientes() {
        return repositorio.findAll();
    }

    public Cliente obterCliente(long id) {
        List<Cliente> clientes = repositorio.findAll();

        return selecionador.selecionar(clientes, id);
    }

    public void cadastrarCliente(Cliente cliente) {
        repositorio.save(cliente);
    }

    public void atualizarCliente(Cliente atualizacao) {
        Cliente cliente = obterCliente(atualizacao.getId());

        if (cliente != null) {
            atualizador.atualizar(cliente, atualizacao);
            repositorio.save(cliente);
        }
    }

    public void excluirCliente(Cliente exclusao) {
        Cliente cliente = obterCliente(exclusao.getId());

        if (cliente != null) {
            repositorio.delete(cliente);
        }
    }
}