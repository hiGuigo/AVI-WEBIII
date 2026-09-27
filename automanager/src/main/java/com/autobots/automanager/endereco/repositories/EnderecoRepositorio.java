package com.autobots.automanager.endereco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.automanager.endereco.entities.Endereco;

public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {

}