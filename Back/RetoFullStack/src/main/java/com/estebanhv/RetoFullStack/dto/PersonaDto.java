package com.estebanhv.RetoFullStack.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class PersonaDto {

	@NotBlank
	private String nombre;
	@NotBlank
	private String apellidos;
	@NotBlank
	private String numeroDocumento;
	@NotBlank
	private String correo;
	@NotBlank
	private String telefono;
	@NotBlank
	private Boolean activo;
	@Min(0)
	private Double salario;
	@NotBlank
	private int departamento;
	
	public PersonaDto() {
	}

	public PersonaDto(@NotBlank String nombre, @NotBlank String apellidos, @NotBlank String numeroDocumento,
			@NotBlank String correo, @NotBlank String telefono, @NotBlank Boolean activo, @Min(0) Double salario,
			@NotBlank int departamento) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.numeroDocumento = numeroDocumento;
		this.correo = correo;
		this.telefono = telefono;
		this.activo = activo;
		this.salario = salario;
		this.departamento = departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

}
