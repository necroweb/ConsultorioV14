package com.app.web.services;

import java.util.List;

import com.app.web.entity.Cita;




public interface CitaServicio {

	public List<Cita> listarCitas();
	
	
	public Cita guardarCita(Cita objCita);
	
	public Cita CitaXid(int id);
	
	public Cita actualizarCita(Cita objCita);
	
	public void eliminarCita(int id);


}
