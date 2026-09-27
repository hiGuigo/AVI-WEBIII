package com.autobots.automanager.telefone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.automanager.telefone.entities.Telefone;

public interface TelefoneRepositorio extends JpaRepository<Telefone, Long> {

}