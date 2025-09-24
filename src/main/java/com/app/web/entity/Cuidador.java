package com.app.web.entity;



import javax.persistence.*;


@Entity
@Table(name="cuidadores")
public class Cuidador {

	//ATRIBUTOS 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="idCuidador")
	private Integer idCuidador;
	
	@Column(name="tipDocumento", nullable=true)
	private String tipoDoc;
	
	@Column(name="cedula")
	private Integer cedula;
	
	@Column(name="Email", nullable=true)
	private String email;
	
	@Column(name="Nombre", nullable=true, length=20)
	private String nombre;
	
	@Column(name="Direccion", nullable=true)
	private String direccion;
	
	@Column(name="Telefono", nullable=true)
	private Integer telefono;
	

	//LLAVE FORANEA 
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, optional=true)
	@JoinColumn(name="idPacienteFK", referencedColumnName="idPaciente")
	private Paciente pacienteCuidador;
	
	@OneToOne(mappedBy="citaCuidador")
	private Cita citasCuidador;
	//CAMBIAR RELACION A --ONETOONE-- UN CUIDADOR x POR UNA CITA 

	public Cuidador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cuidador(Integer idCuidador, String tipoDoc, Integer cedula, String email, String nombre, String direccion,
			Integer telefono, Paciente pacienteCuidador, Cita citasCuidador) {
		super();
		this.idCuidador = idCuidador;
		this.tipoDoc = tipoDoc;
		this.cedula = cedula;
		this.email = email;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.pacienteCuidador = pacienteCuidador;
		this.citasCuidador = citasCuidador;
	}
	public Integer getIdCuidador() {
		return idCuidador;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public Integer getCedula() {
		return cedula;
	}
	public String getEmail() {
		return email;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public Paciente getPacienteCuidador() {
		return pacienteCuidador;
	}
	public Cita getCitasCuidador() {
		return citasCuidador;
	}
	public void setIdCuidador(Integer idCuidador) {
		this.idCuidador = idCuidador;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public void setPacienteCuidador(Paciente pacienteCuidador) {
		this.pacienteCuidador = pacienteCuidador;
	}
	public void setCitasCuidador(Cita citasCuidador) {
		this.citasCuidador = citasCuidador;
	}
	@Override
	public String toString() {
		return "Cuidador [idCuidador=" + idCuidador + ", tipoDoc=" + tipoDoc + ", cedula=" + cedula + ", email=" + email
				+ ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", pacienteCuidador="
				+ pacienteCuidador + ", citasCuidador=" + citasCuidador + "]";
	}

	
}
