package com.autobots.automanager.documento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autobots.automanager.documento.entities.Documento;

public interface DocumentoRepositorio extends JpaRepository<Documento, Long> {

}