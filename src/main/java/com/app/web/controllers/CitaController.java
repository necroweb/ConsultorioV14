package com.app.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entity.Cita;
import com.app.web.entity.Cuidador;
import com.app.web.services.CitaServicio;

@Controller
public class CitaController {

	@Autowired
	private CitaServicio servicio;
	
	//LISTAR PETICION GET CITAS
	@GetMapping({"/citas/cita"})
	public String listarCitas(Model modelo) {
		modelo.addAttribute("citas", 
				servicio.listarCitas());
		return "/citas/cita";
		
	}
	
	//PETICION MOSTRAR 
	@GetMapping({"/citas/agendar"})
	public String formularioAgendar(Model modelo) {
		Cita objCita = new Cita();
		Cuidador objCuidador = new Cuidador();
		modelo.addAttribute("cita", objCita);
		modelo.addAttribute("cuidador", objCuidador);
		return "/citas/agendar";
	}

	//PETICION DE INSERTAR CITA 
	@PostMapping("/citas/cita")
	public String guardarCita(@ModelAttribute("cita") Cita objCita,
							  @ModelAttribute("cuidador") Cuidador objCuidador)
	{
		objCuidador.setCitasCuidador(objCita);
		objCita.setCitaCuidador(objCuidador);
		servicio.guardarCita(objCita);
		return "redirect:/citas/cita";
	}
	
	//METODO PARA MOSTRAR FORM EDITAR 
		@GetMapping("/citas/actualizar/{id}")
		public String editarCita(@PathVariable int id, Model modelo) {
			modelo.addAttribute("cita", servicio.CitaXid(id));
			return "/citas/actualizar";
		}
		
		//METODO PARA ACTUALIZAR CITA 
		@PostMapping("/citas/actualizar/{id}")
		public String actualizarCita(@PathVariable int id, 
								@ModelAttribute("cita") Cita objCita) {
		Cita citaExistente = servicio.CitaXid(id);
		citaExistente.setIdCita(id);
		citaExistente.setFecha(objCita.getFecha());
		citaExistente.setHora(objCita.getHora());
		citaExistente.setMotivo(objCita.getMotivo());
		
		servicio.actualizarCita(citaExistente);
		return "redirect:/citas/cita";
		
		}
		
		@GetMapping("/citas/eliminar/{id}")
		public String borrarCita(@PathVariable int id){
			servicio.eliminarCita(id);
			return "redirect:/citas/cita";
		}
		
	
}
