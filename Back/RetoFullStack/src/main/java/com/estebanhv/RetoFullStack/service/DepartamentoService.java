package com.estebanhv.RetoFullStack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estebanhv.RetoFullStack.entity.Departamentos;
import com.estebanhv.RetoFullStack.repository.DepartamentoRepository;

@Service
@Transactional
public class DepartamentoService {
	
	@Autowired
	DepartamentoRepository departamentoRepository;
	
	public List<Departamentos> list(){
		return departamentoRepository.findAll();
	}
	
	public Optional<Departamentos> getOne(int id){
		return departamentoRepository.findById(id);
	}
	
	public Optional<Departamentos> getByNombre(String nombre){
		return departamentoRepository.findByNombre(nombre);
	}
	
	public Optional<Departamentos> getByCodigo(int codigo){
		return departamentoRepository.findByCodigo(codigo);
	}
	
	public void save(Departamentos departamento) {
		departamentoRepository.save(departamento);
	}

	public void delete(int id) {
		departamentoRepository.deleteById(id);
	}
	
	public Boolean existsById(int id) {
		return departamentoRepository.existsById(id);
	}
	
	public Boolean existsByNombre(String nombre) {
		return departamentoRepository.existsByNombre(nombre);
	}
	
	public Boolean existsByCodigo(int codigo) {
		return departamentoRepository.existsByCodigo(codigo);
	}

}
