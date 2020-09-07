package com.ayd1.proyectoclase.controller.inte;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayd1.proyectoclase.model.BusquedaLibroDto;

@CrossOrigin
@RestController
@RequestMapping(path="/aydws/libro")
public interface AydLibroInt {
	
	@PostMapping(path="/titulo")
	ResponseEntity<?> getUsuarios(@RequestBody BusquedaLibroDto busqueda);

}
