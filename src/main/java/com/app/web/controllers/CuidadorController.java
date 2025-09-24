package com.app.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entity.Cuidador;
import com.app.web.entity.Paciente;
import com.app.web.services.CuidadorServicio;


@Controller
public class CuidadorController {
	
	//ATRIBUTO
	@Autowired
	private CuidadorServicio servicio;
	
	//LISTAR PETICION 
		@GetMapping({"/user/lista"})
		public String listUsuarios(Model modelo) {
			modelo.addAttribute("cuidadores", 
				servicio.listarCuidadores()	);
			return "/user/lista";
		}

	
	//FORMULARIO 
	//PETICION MOSTRAR  FORMULARIO 
	@GetMapping({"/user/create", "/"})
	public String formularioCrear(Model modelo) {
		Cuidador objCuidador = new Cuidador();
		Paciente objPaciente = new Paciente();
		modelo.addAttribute("Cuidador", objCuidador);
		modelo.addAttribute("Paciente", objPaciente);
		return "/user/create";
	}

	//PETICION INSERTAR CUIDADOR
	@PostMapping("/user/lista")
	public String guardarCuidador(@ModelAttribute("cuidador") Cuidador objCuidador,
								  @ModelAttribute("paciente") Paciente objPaciente)
	{
		objPaciente.setPacienteCuidador(objCuidador);
		objCuidador.setPacienteCuidador(objPaciente);
		servicio.guardarCuidador(objCuidador);
		return "redirect:/citas/cita";
		
	}
	
	
	//METODO PARA MOSTRAR FORM EDITAR 
		@GetMapping("/user/editar/{id}")
		public String formularioEditar(@PathVariable int id, Model modelo){
			modelo.addAttribute("cuidador", servicio.CuidadorXid(id));
			return "/user/editar";
		}

	
		//METODO PARA ACTUALIZAR 
		@PostMapping("/user/lista/{id}")
		public String actualizarCuidador(@PathVariable int id,
									@ModelAttribute("cuidador") Cuidador objCuidador) {
									
		Cuidador cuidadorExistente = servicio.CuidadorXid(id);	
		cuidadorExistente.setIdCuidador(id);
		cuidadorExistente.setTipoDoc(objCuidador.getTipoDoc());
		cuidadorExistente.setCedula(objCuidador.getCedula());
		cuidadorExistente.setEmail(objCuidador.getEmail());
		cuidadorExistente.setNombre(objCuidador.getNombre());
		cuidadorExistente.setDireccion(objCuidador.getDireccion());
		cuidadorExistente.setTelefono(objCuidador.getTelefono());
		
		servicio.actualizarCuidador(cuidadorExistente);
		return "redirect:/user/lista";
		
		}
		
		@GetMapping("/user/eliminar/{id}")
		public String borrarCuidador(@PathVariable int id) {
			servicio.eliminarCliente(id);
			return "redirect:/user/lista";
		}


}
