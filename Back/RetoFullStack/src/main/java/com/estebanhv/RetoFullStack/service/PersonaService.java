package com.estebanhv.RetoFullStack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estebanhv.RetoFullStack.entity.Personas;
import com.estebanhv.RetoFullStack.repository.PersonaRepository;

@Service
@Transactional
public class PersonaService {

	@Autowired
	PersonaRepository personaRepository;
	
	public List<Personas> list(){
		return personaRepository.findAll();
	}
	
	public Optional<Personas> getOne(int id){
		return personaRepository.findById(id);
	}
	
	public Optional<Personas> getByNombre(String nombre){
		return personaRepository.findByNombre(nombre);
	}
	
	public Optional<Personas> getByNumeroDocumento(String numeroDocumento){
		return personaRepository.findByNumeroDocumento(numeroDocumento);
	}
	
	public void save(Personas persona) {
		personaRepository.save(persona);
	}

	public void delete(int id) {
		personaRepository.deleteById(id);
	}
	
	public Boolean existsById(int id) {
		return personaRepository.existsById(id);
	}
	
	public Boolean existsByNombre(String nombre) {
		return personaRepository.existsByNombre(nombre);
	}
	
	public Boolean existsByNumeroDocumento(String numeroDocumento) {
		return personaRepository.existsByNumeroDocumento(numeroDocumento);
	}
	
//	public Boolean existsByDepartamento(int departamento) {
//		return personaRepository.existsByDepartamento(departamento);
//	}
	
}
