package com.app.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entity.Paciente;

@Repository
public interface PacienteRepository extends 
JpaRepository<Paciente,Integer>{

}
