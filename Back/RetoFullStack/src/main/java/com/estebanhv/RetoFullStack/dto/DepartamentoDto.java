package com.estebanhv.RetoFullStack.dto;

import javax.validation.constraints.NotBlank;

public class DepartamentoDto {
	
	@NotBlank
	private String nombre;
	@NotBlank
	private String descripcion;
	@NotBlank
	private int codigo;
	
	public DepartamentoDto() {
	}

	public DepartamentoDto(@NotBlank String nombre, @NotBlank String descripcion, @NotBlank int codigo) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigo = codigo;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
