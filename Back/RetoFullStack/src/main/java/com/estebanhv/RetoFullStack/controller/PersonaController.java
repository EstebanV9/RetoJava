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

import com.estebanhv.RetoFullStack.dto.Mensaje;
import com.estebanhv.RetoFullStack.dto.PersonaDto;
import com.estebanhv.RetoFullStack.entity.Personas;
import com.estebanhv.RetoFullStack.service.DepartamentoService;
import com.estebanhv.RetoFullStack.service.PersonaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping({ "/personas" })
public class PersonaController {

	@Autowired
	PersonaService personaService;
	@Autowired
	DepartamentoService departamentoService;

	@GetMapping("/lista")
	public ResponseEntity<List<Personas>> list() {
		List<Personas> list = personaService.list();
		return new ResponseEntity<List<Personas>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/detalles/{id}")
	public ResponseEntity<Personas> getById(@PathVariable("id") int id){
		if(!personaService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Personas persona = personaService.getOne(id).get();
		return new ResponseEntity(persona, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/detallesNombre/{nombre}")
	public ResponseEntity<Personas> getByNombre(@PathVariable("nombre") String nombre){
		if(!personaService.existsByNombre(nombre))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Personas persona = personaService.getByNombre(nombre).get();
		return new ResponseEntity(persona, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/detallesNumeroDocumento/{numeroDocumento}")
	public ResponseEntity<Personas> getByNumeroDocumento(@PathVariable("numeroDocumento") String numeroDocumento){
		if(!personaService.existsByNumeroDocumento(numeroDocumento))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Personas persona = personaService.getByNumeroDocumento(numeroDocumento).get();
		return new ResponseEntity(persona, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody PersonaDto personaDto){
		if(StringUtils.isBlank(personaDto.getNombre()))
			return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(personaDto.getApellidos()))
			return new ResponseEntity(new Mensaje("Los Apellidos son Obligatorios"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(personaDto.getNumeroDocumento()))
			return new ResponseEntity(new Mensaje("El Número de Documento es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(personaDto.getCorreo()))
			return new ResponseEntity(new Mensaje("El Correo es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(personaDto.getTelefono()))
			return new ResponseEntity(new Mensaje("El Teléfono es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(personaDto.getActivo()!=true && personaDto.getActivo()!=false)
			return new ResponseEntity(new Mensaje("El Estado (Activo) es Obligatorio, Indicar: true o false"), HttpStatus.BAD_REQUEST);
		if(personaDto.getSalario()==null || personaDto.getSalario()<0)
			return new ResponseEntity(new Mensaje("El Salario No Puede ser Menor a 0"), HttpStatus.BAD_REQUEST);
		if(!departamentoService.existsById(personaDto.getDepartamento()))
			return new ResponseEntity(new Mensaje("No Existe Departamento por el ID Indicado"), HttpStatus.BAD_REQUEST);
		if(personaService.existsByNumeroDocumento(personaDto.getNumeroDocumento()))
			return new ResponseEntity(new Mensaje("El Número de Documento Ya Existe"), HttpStatus.BAD_REQUEST);
		Personas persona = new Personas(personaDto.getNombre(), personaDto.getApellidos(), personaDto.getNumeroDocumento(), personaDto.getCorreo(), personaDto.getTelefono(), personaDto.getActivo(), personaDto.getSalario(), personaDto.getDepartamento());
		personaService.save(persona);
		return new ResponseEntity(new Mensaje("Persona Registrada Exitosamente!"), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PersonaDto personaDto){
		if(!personaService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe Persona por el ID Indicado"), HttpStatus.NOT_FOUND);
		if(personaService.existsByNumeroDocumento(personaDto.getNumeroDocumento()) && personaService.getByNumeroDocumento(personaDto.getNumeroDocumento()).get().getId() != id)
			return new ResponseEntity(new Mensaje("El Número de Documento Ya Existe"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(personaDto.getNombre()))
				return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(personaDto.getApellidos()))
			return new ResponseEntity(new Mensaje("Los Apellidos son Obligatorios"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(personaDto.getNumeroDocumento()))
			return new ResponseEntity(new Mensaje("El Número de Documento es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(personaDto.getCorreo()))
			return new ResponseEntity(new Mensaje("El Correo es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(personaDto.getTelefono()))
			return new ResponseEntity(new Mensaje("El Teléfono es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(personaDto.getActivo()!=true && personaDto.getActivo()!=false)
			return new ResponseEntity(new Mensaje("El Estado (Activo) es Obligatorio, Indicar: true o false"), HttpStatus.BAD_REQUEST);
		if(personaDto.getSalario()==null || personaDto.getSalario()<0)
			return new ResponseEntity(new Mensaje("El Salario No Puede ser Menor a 0"), HttpStatus.BAD_REQUEST);
		if(!departamentoService.existsById(personaDto.getDepartamento()))
			return new ResponseEntity(new Mensaje("No Existe Departamento por el ID Indicado"), HttpStatus.BAD_REQUEST);
		Personas persona = personaService.getOne(id).get();
		persona.setNombre(personaDto.getNombre());
		persona.setApellidos(personaDto.getApellidos());
		persona.setNumeroDocumento(personaDto.getNumeroDocumento());
		persona.setCorreo(personaDto.getCorreo());
		persona.setTelefono(personaDto.getTelefono());
		persona.setActivo(personaDto.getActivo());
		persona.setSalario(personaDto.getSalario());
		persona.setDepartamento(personaDto.getDepartamento());
		personaService.save(persona);
		return new ResponseEntity(new Mensaje("Persona Actualizada Exitosamente!"), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if(!personaService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe Persona por el ID Indicado"), HttpStatus.NOT_FOUND);
		personaService.delete(id);
		return new ResponseEntity(new Mensaje("Persona Eliminada Exitosamente!"), HttpStatus.OK);
	}

}
