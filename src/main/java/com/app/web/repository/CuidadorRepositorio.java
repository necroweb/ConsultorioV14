package com.app.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.web.entity.Cuidador;

@Repository
public interface CuidadorRepositorio extends 
JpaRepository<Cuidador, Integer>{

}
