package com.ayd1.proyectoclase.repository;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ayd1.proyectoclase.entity.Usuario;

public interface UsuarioRep extends PagingAndSortingRepository<Usuario, Serializable>{

}
