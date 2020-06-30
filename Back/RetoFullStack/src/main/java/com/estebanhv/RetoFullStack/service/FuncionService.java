package com.estebanhv.RetoFullStack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estebanhv.RetoFullStack.entity.Funciones;
import com.estebanhv.RetoFullStack.repository.FuncionRepository;

@Service
@Transactional
public class FuncionService {
	
	@Autowired
	FuncionRepository funcionRepository;
	
	public List<Funciones> list(){
		return funcionRepository.findAll();
	}
	
	public Optional<Funciones> getOne(int id){
		return funcionRepository.findById(id);
	}
	
	public Optional<Funciones> getByNombre(String nombre){
		return funcionRepository.findByNombre(nombre);
	}
	
	public void save(Funciones funcion) {
		funcionRepository.save(funcion);
	}

	public void delete(int id) {
		funcionRepository.deleteById(id);
	}
	
	public Boolean existsById(int id) {
		return funcionRepository.existsById(id);
	}
	
	public Boolean existsByNombre(String nombre) {
		return funcionRepository.existsByNombre(nombre);
	}
	
//	public Boolean existsByDepartamento(int departamento) {
//		return funcionRepository.existsByDepartamento(departamento);
//	}
	
}
