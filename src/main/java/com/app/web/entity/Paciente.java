package com.app.web.entity;

import javax.persistence.*;

@Entity
@Table(name="pacientes")
public class Paciente {
	
	//ATRIBUTOS 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="idPaciente")
	private Integer idPaciente;
	
	@Column(name="nombrePaciente", nullable=true, length=20 )
	private String nombre;
	
	@Column(name="especie", nullable=true, length=20 )
	private String especie;
	
	@Column(name="raza", nullable=true, length=20)
	private String raza;
	
	@Column(name="edad", nullable=true)
	private Integer edad;
	
	@Column(name="sexo", nullable=true)
	private String sexo;
	
	@Column(name="color", nullable=true, length=20)
	private String color;

	//LLAVE FORANEA

	@OneToOne(mappedBy="pacienteCuidador")
	private Cuidador pacienteCuidador;

	@OneToOne(mappedBy="pacienteCita")
	private Cita pacienteCita;

	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(Integer idPaciente, String nombre, String especie, String raza, Integer edad, String sexo,
			String color, Cuidador pacienteCuidador, Cita pacienteCita) {
		super();
		this.idPaciente = idPaciente;
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.edad = edad;
		this.sexo = sexo;
		this.color = color;
		this.pacienteCuidador = pacienteCuidador;
		this.pacienteCita = pacienteCita;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEspecie() {
		return especie;
	}

	public String getRaza() {
		return raza;
	}

	public Integer getEdad() {
		return edad;
	}

	public String getSexo() {
		return sexo;
	}

	public String getColor() {
		return color;
	}

	public Cuidador getPacienteCuidador() {
		return pacienteCuidador;
	}

	public Cita getPacienteCita() {
		return pacienteCita;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setPacienteCuidador(Cuidador pacienteCuidador) {
		this.pacienteCuidador = pacienteCuidador;
	}

	public void setPacienteCita(Cita pacienteCita) {
		this.pacienteCita = pacienteCita;
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", nombre=" + nombre + ", especie=" + especie + ", raza=" + raza
				+ ", edad=" + edad + ", sexo=" + sexo + ", color=" + color + ", pacienteCuidador=" + pacienteCuidador
				+ ", pacienteCita=" + pacienteCita + "]";
	}

	
}
