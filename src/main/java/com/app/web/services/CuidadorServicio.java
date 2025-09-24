package com.app.web.services;

import java.util.List;

import com.app.web.entity.Cuidador;


public interface CuidadorServicio {
	
		public List<Cuidador> listarCuidadores();
	
		public Cuidador guardarCuidador(Cuidador objCuidador);

		public Cuidador CuidadorXid(int id);
				
		public Cuidador actualizarCuidador(Cuidador objCuidador);
	
		public void eliminarCliente(int id);
}
