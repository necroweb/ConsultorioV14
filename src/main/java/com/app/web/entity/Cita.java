package com.app.web.entity;

import javax.persistence.*;

@Entity
@Table(name="Cita")	
public class Cita {

	//ATRIBUTOS
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCita")
	private Integer idCita;
	
	@Column(name="fechaCita", nullable=true, length=20)
	private String fecha;
	
	@Column(name="horaCita", nullable=true, length=20)
	private String hora;
	
	@Column(name="motivoCita", nullable=true, length=100)
	private String motivo;  
	
	//LAVES FOREANEAS
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, optional=true)
	@JoinColumn(name="idCuidadorFK", referencedColumnName="idCuidador" )
	public Cuidador citaCuidador;

	@OneToOne (cascade=CascadeType.ALL, fetch = FetchType.LAZY, optional=true)
	@JoinColumn(name="idPacienteFK", referencedColumnName="idPaciente" )
	public Paciente pacienteCita;

	public Cita() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cita(Integer idCita, String fecha, String hora, String motivo, Cuidador citaCuidador,
			Paciente pacienteCita) {
		super();
		this.idCita = idCita;
		this.fecha = fecha;
		this.hora = hora;
		this.motivo = motivo;
		this.citaCuidador = citaCuidador;
		this.pacienteCita = pacienteCita;
	}

	public Integer getIdCita() {
		return idCita;
	}

	public String getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}

	public String getMotivo() {
		return motivo;
	}

	public Cuidador getCitaCuidador() {
		return citaCuidador;
	}

	public Paciente getPacienteCita() {
		return pacienteCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public void setCitaCuidador(Cuidador citaCuidador) {
		this.citaCuidador = citaCuidador;
	}

	public void setPacienteCita(Paciente pacienteCita) {
		this.pacienteCita = pacienteCita;
	}

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", fecha=" + fecha + ", hora=" + hora + ", motivo=" + motivo
				+ ", citaCuidador=" + citaCuidador + ", pacienteCita=" + pacienteCita + "]";
	}
	
	
}
