package com.app.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entity.Cita;

import com.app.web.repository.CitaRepository;

@Service
public class CitaServicioimp implements CitaServicio {

	@Autowired
	private CitaRepository repositorio; 
	
	@Override
	public List<Cita> listarCitas() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Cita guardarCita(Cita objCita) {
		// TODO Auto-generated method stub
		return repositorio.save(objCita);
	}

	@Override
	public Cita CitaXid(int id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).get();
	}

	//IMPLEMENTAR METODO ID POR CUIDADOR 
	@Override
	public Cita actualizarCita(Cita objCita) {
		// TODO Auto-generated method stub
		return repositorio.save(objCita);
	}

	@Override
	public void eliminarCita(int id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
	}

	
}
