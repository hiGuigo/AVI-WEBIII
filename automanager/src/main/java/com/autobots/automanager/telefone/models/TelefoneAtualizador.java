package com.autobots.automanager.telefone.models;

import java.util.List;

import org.springframework.stereotype.Component;

import com.autobots.automanager.telefone.entities.Telefone;
import com.autobots.automanager.utils.StringVerificadorNulo;

@Component
public class TelefoneAtualizador {

    private final StringVerificadorNulo verificador;

    public TelefoneAtualizador(StringVerificadorNulo verificador) {
        this.verificador = verificador;
    }

    public void atualizar(Telefone telefone, Telefone atualizacao) {

        if (atualizacao != null) {

            if (!verificador.verificar(atualizacao.getDdd())) {
                telefone.setDdd(atualizacao.getDdd());
            }

            if (!verificador.verificar(atualizacao.getNumero())) {
                telefone.setNumero(atualizacao.getNumero());
            }
        }
    }

    public void atualizar(
        List<Telefone> telefones,
        List<Telefone> atualizacoes
    ) {
        for (Telefone atualizacao : atualizacoes) {

            for (Telefone telefone : telefones) {

                if (atualizacao.getId() != null &&
                    atualizacao.getId().equals(telefone.getId())) {

                    atualizar(telefone, atualizacao);
                }
            }
        }
    }
}