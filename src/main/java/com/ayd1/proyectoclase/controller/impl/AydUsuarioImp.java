package com.ayd1.proyectoclase.controller.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ayd1.proyectoclase.controller.inte.AydUsuarioInt;
import com.ayd1.proyectoclase.entity.Usuario;
import com.ayd1.proyectoclase.model.LoginDto;
import com.ayd1.proyectoclase.repository.UsuarioRep;

@Component
public class AydUsuarioImp implements AydUsuarioInt{
	
	@Autowired
	protected UsuarioRep usuarioRep;

	@Override
	public ResponseEntity<?> getUsuarios() {
		return new ResponseEntity<>(usuarioRep.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> login(LoginDto loginDto) {
		Optional<Usuario> optUsuario = usuarioRep.findById(loginDto.getCarnet());
		if(optUsuario.isPresent()) {
			Usuario u = optUsuario.get();
			if(u.getPassword().equals(loginDto.getPassword())) {
				return new ResponseEntity<>("Login exitoso", HttpStatus.OK);	
			}else {
				return new ResponseEntity<>("Contraseña incorrecta", HttpStatus.BAD_REQUEST);	
			}
		} else {
			return new ResponseEntity<>("Usuario no encontrado", HttpStatus.BAD_REQUEST);
		}
	}

}
