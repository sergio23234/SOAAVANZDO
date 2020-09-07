package com.ayd1.proyectoclase.controller.inte;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayd1.proyectoclase.model.LoginDto;


@CrossOrigin
@RestController
@RequestMapping(path="/aydws/usuarios")
public interface AydUsuarioInt {
	
	@GetMapping(path="/")
	ResponseEntity<?> getUsuarios();
	
	@GetMapping(path = "/login") 
	ResponseEntity<?> login(@RequestBody LoginDto loginDto);
	
	
}
