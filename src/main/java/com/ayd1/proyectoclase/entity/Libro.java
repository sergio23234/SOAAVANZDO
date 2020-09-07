package com.ayd1.proyectoclase.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Libro", schema = "public")
public class Libro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7125228161081742146L;
	
	@Id
	@Column(name="id_libro")
	private Integer idLibro;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="autor")
	private String autor;
	
	@Column(name="fecha_edicion")
	private Date fechaEdicion;
	
	@Column(name="edicion")
	private String edicion;
	
	@Column(name="editorial")
	private String editorial;
	
	

}
