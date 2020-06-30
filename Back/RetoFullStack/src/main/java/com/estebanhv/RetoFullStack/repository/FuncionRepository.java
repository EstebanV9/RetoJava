package com.estebanhv.RetoFullStack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estebanhv.RetoFullStack.entity.Funciones;

@Repository
public interface FuncionRepository extends JpaRepository<Funciones, Integer>{
	
	Optional<Funciones> findByNombre(String nombre);
	Boolean existsByNombre(String nombre);
	
//	Optional<Funciones> findByDepartamento(int departamento);
//	Boolean existsByDepartamento(int departamento);

}
