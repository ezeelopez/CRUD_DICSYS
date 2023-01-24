package com.dicsys.proyecto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persona {
    
	@Id
	private Integer id;

	@Column (name= "NOMBRE") 
	private String nombre;
	
	@Column (name = "APELLIDO" )
	private String apellido;
	
	@Column(name = "SEXO")
	private String sexo;
	
	@Column(name = "DOCUMENTO")
	private Integer docuemnto;
	
	@Column(name = "EDAD")
	private Integer edad;

	
	public Persona() {
		super();
	}

	public Persona(String nombre, String apellido, String sexo, Integer docuemnto, Integer edad, Integer id) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.docuemnto = docuemnto;
		this.edad = edad;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getDocuemnto() {
		return docuemnto;
	}

	public void setDocuemnto(Integer docuemnto) {
		this.docuemnto = docuemnto;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
