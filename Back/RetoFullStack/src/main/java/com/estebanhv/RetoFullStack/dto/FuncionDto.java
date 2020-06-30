package com.estebanhv.RetoFullStack.dto;

import javax.validation.constraints.NotBlank;

public class FuncionDto {
	
	@NotBlank
	private String nombre;
	private String descripcion;
	@NotBlank
	private int departamento;
	
	public FuncionDto() {
	}

	public FuncionDto(@NotBlank String nombre, String descripcion, @NotBlank int departamento) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
	
	

}
