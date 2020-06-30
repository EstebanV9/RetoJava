package com.estebanhv.RetoFullStack.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.estebanhv.RetoFullStack.entity.Personas;

@Repository
public interface PersonaRepository extends JpaRepository<Personas, Integer> {

	Optional<Personas> findByNombre(String nombre);
	Boolean existsByNombre(String nombre);
	
	Optional<Personas> findByNumeroDocumento(String numeroDocumento);
	Boolean existsByNumeroDocumento(String numeroDocumento);
	
//	Optional<Personas> findByDepartamento(int departamento);
//	Boolean existsByDepartamento(int departamento);

}
