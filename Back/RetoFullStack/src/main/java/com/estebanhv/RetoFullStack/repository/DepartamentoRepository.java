package com.estebanhv.RetoFullStack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estebanhv.RetoFullStack.entity.Departamentos;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamentos, Integer>{
	
//	Optional<Departamentos> findById(int id);
//	Boolean existsById(int id);
	
	Optional<Departamentos> findByNombre(String nombre);
	Boolean existsByNombre(String nombre);
	
	Optional<Departamentos> findByCodigo(int codigo);
	Boolean existsByCodigo(int codigo);

}
