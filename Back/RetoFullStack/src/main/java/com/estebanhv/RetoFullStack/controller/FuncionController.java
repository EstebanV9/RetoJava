package com.estebanhv.RetoFullStack.controller;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estebanhv.RetoFullStack.dto.FuncionDto;
import com.estebanhv.RetoFullStack.dto.Mensaje;
import com.estebanhv.RetoFullStack.entity.Funciones;
import com.estebanhv.RetoFullStack.service.DepartamentoService;
import com.estebanhv.RetoFullStack.service.FuncionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping({ "/funciones" })
public class FuncionController {
	
	@Autowired
	FuncionService funcionService;
	@Autowired
	DepartamentoService departamentoService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Funciones>> list() {
		List<Funciones> list = funcionService.list();
		return new ResponseEntity<List<Funciones>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/detalles/{id}")
	public ResponseEntity<Funciones> getById(@PathVariable("id") int id){
		if(!funcionService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Funciones funcion = funcionService.getOne(id).get();
		return new ResponseEntity(funcion, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/detallesNombre/{nombre}")
	public ResponseEntity<Funciones> getByNombre(@PathVariable("nombre") String nombre){
		if(!funcionService.existsByNombre(nombre))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Funciones funcion = funcionService.getByNombre(nombre).get();
		return new ResponseEntity(funcion, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody FuncionDto funcionDto){
		if(StringUtils.isBlank(funcionDto.getNombre()))
			return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(funcionService.existsByNombre(funcionDto.getNombre()))
			return new ResponseEntity(new Mensaje("El Nombre de Función Ya Existe"), HttpStatus.BAD_REQUEST);
		if(!departamentoService.existsById(funcionDto.getDepartamento()))
			return new ResponseEntity(new Mensaje("No Existe Departamento por el ID Indicado"), HttpStatus.BAD_REQUEST);
		Funciones funcion = new Funciones(funcionDto.getNombre(), funcionDto.getDescripcion(), funcionDto.getDepartamento());
		funcionService.save(funcion);
		return new ResponseEntity(new Mensaje("Función Registrada Exitosamente!"), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody FuncionDto funcionDto){
		if(!funcionService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe Función por el ID Indicado"), HttpStatus.NOT_FOUND);
		if(StringUtils.isBlank(funcionDto.getNombre()))
				return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(!departamentoService.existsById(funcionDto.getDepartamento()))
			return new ResponseEntity(new Mensaje("No Existe Departamento por el ID Indicado"), HttpStatus.NOT_FOUND);
		Funciones funcion = funcionService.getOne(id).get();
		funcion.setNombre(funcionDto.getNombre());
		funcion.setDescripcion(funcionDto.getDescripcion());
		funcion.setDepartamento(funcionDto.getDepartamento());
		funcionService.save(funcion);
		return new ResponseEntity(new Mensaje("Función Actualizada Exitosamente!"), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if(!funcionService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe Función por el ID Indicado"), HttpStatus.NOT_FOUND);
		funcionService.delete(id);
		return new ResponseEntity(new Mensaje("Función Eliminada Exitosamente!"), HttpStatus.OK);
	}

}
