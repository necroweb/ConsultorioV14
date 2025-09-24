 package com.app.web.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entity.Cuidador;

import com.app.web.repository.CuidadorRepositorio;

@Service
public class CuidadorServiceimp implements CuidadorServicio{

	@Autowired
	private CuidadorRepositorio repositorio; 
 
	//PETICION LISTAR DE MYSQL 
	@Override
	public List<Cuidador> listarCuidadores() {
		return repositorio.findAll();
	}

	
	@Override
	public Cuidador guardarCuidador(Cuidador objCuidador) {
		// TODO Auto-generated method stub
		return  repositorio.save(objCuidador);
	}

	@Override
	public Cuidador CuidadorXid(int id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	@Override
	public Cuidador actualizarCuidador(Cuidador objCuidador) {
		// TODO Auto-generated method stub
		return repositorio.save(objCuidador);
	}

	@Override
	public void eliminarCliente(int id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	
}
