package com.ayd1.proyectoclase.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ayd1.proyectoclase.entity.Libro;

public interface LibroRep extends PagingAndSortingRepository<Libro, Serializable>{
		
	List<Libro> findByTituloContaining(String titulo);
	
}
