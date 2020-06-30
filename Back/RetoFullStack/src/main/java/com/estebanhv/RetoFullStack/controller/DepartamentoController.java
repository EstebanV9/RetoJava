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
import com.estebanhv.RetoFullStack.dto.DepartamentoDto;
import com.estebanhv.RetoFullStack.dto.Mensaje;
import com.estebanhv.RetoFullStack.entity.Departamentos;
import com.estebanhv.RetoFullStack.service.DepartamentoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping({ "/departamentos" })
public class DepartamentoController {
	
	@Autowired
	DepartamentoService departamentoService;
	
	@GetMapping("/lista")
	public ResponseEntity<List<Departamentos>> list() {
		List<Departamentos> list = departamentoService.list();
		return new ResponseEntity<List<Departamentos>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/detalles/{id}")
	public ResponseEntity<Departamentos> getById(@PathVariable("id") int id){
		if(!departamentoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Departamentos departamento = departamentoService.getOne(id).get();
		return new ResponseEntity(departamento, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/detallesNombre/{nombre}")
	public ResponseEntity<Departamentos> getByNombre(@PathVariable("nombre") String nombre){
		if(!departamentoService.existsByNombre(nombre))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Departamentos departamento = departamentoService.getByNombre(nombre).get();
		return new ResponseEntity(departamento, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/detallesCodigo/{codigo}")
	public ResponseEntity<Departamentos> getByCodigo(@PathVariable("codigo") int codigo){
		if(!departamentoService.existsByCodigo(codigo))
			return new ResponseEntity(new Mensaje("No Existe"), HttpStatus.NOT_FOUND);
		Departamentos departamento = departamentoService.getByCodigo(codigo).get();
		return new ResponseEntity(departamento, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/crear")
	public ResponseEntity<?> create(@RequestBody DepartamentoDto departamentoDto){
		if(StringUtils.isBlank(departamentoDto.getNombre()))
			return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(departamentoDto.getDescripcion()))
			return new ResponseEntity(new Mensaje("La Descripción es Obligatoria"), HttpStatus.BAD_REQUEST);
		if(departamentoService.existsByCodigo(departamentoDto.getCodigo()))
			return new ResponseEntity(new Mensaje("El Código de Departamento Ya Existe"), HttpStatus.BAD_REQUEST);
		Departamentos departamento = new Departamentos(departamentoDto.getNombre(), departamentoDto.getDescripcion(), departamentoDto.getCodigo());
		departamentoService.save(departamento);
		return new ResponseEntity(new Mensaje("Departamento Registrado Exitosamente!"), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DepartamentoDto departamentoDto){
		if(!departamentoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe Departamento por el ID Indicado"), HttpStatus.NOT_FOUND);
		if(departamentoService.existsByCodigo(departamentoDto.getCodigo()) && departamentoService.getByCodigo(departamentoDto.getCodigo()).get().getId() != id)
			return new ResponseEntity(new Mensaje("El Código de Departamento Ya Existe"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(departamentoDto.getNombre()))
				return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(departamentoDto.getDescripcion()))
			return new ResponseEntity(new Mensaje("La Descripción es Obligatoria"), HttpStatus.BAD_REQUEST);
		Departamentos departamento = departamentoService.getOne(id).get();
		departamento.setNombre(departamentoDto.getNombre());
		departamento.setDescripcion(departamentoDto.getDescripcion());
		departamento.setCodigo(departamentoDto.getCodigo());
		departamentoService.save(departamento);
		return new ResponseEntity(new Mensaje("Departamento Actualizado Exitosamente!"), HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if(!departamentoService.existsById(id))
			return new ResponseEntity(new Mensaje("No Existe Departamento por el ID Indicado"), HttpStatus.NOT_FOUND);
		departamentoService.delete(id);
		return new ResponseEntity(new Mensaje("Departamento Eliminado Exitosamente!"), HttpStatus.OK);
	}

}
