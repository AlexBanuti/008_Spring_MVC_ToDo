package com.curso.tablero.domain;

import java.io.Serializable;
import java.util.Objects;

public class Tarea implements Serializable{

	private static final long serialVersionUID = 2L;
	
	private Integer id; //pk
	private String titulo;
	private String descripcion;
	private Estados estado;
	
	public Tarea() {
		super();
		estado = Estados.TODO;
	}

	public Tarea(Integer id, String titulo, String descripcion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = Estados.TODO;
	}
	
	
	//gettes y setter
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	//equals y hascode
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarea other = (Tarea) obj;
		return Objects.equals(id, other.id);
	}

	
	//tostring
	@Override
	public String toString() {
		return "Tarea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
	

}
