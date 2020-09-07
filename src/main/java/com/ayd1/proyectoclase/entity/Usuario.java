package com.ayd1.proyectoclase.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usuario", schema = "public")
public class Usuario {
	
	@Id
	@Column(name="carnet")
	private Integer carnet;
	
	@Column(name="nombre")
	private String nomre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="dpi")
	private String dpi;
	
	@Column(name="telefono")
	private Integer telefono;
	
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "password")
	private String password;
	

}
