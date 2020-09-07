package com.ayd1.proyectoclase.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5275607482693975573L;
	
	private Integer carnet;
	private String password;
	
}
