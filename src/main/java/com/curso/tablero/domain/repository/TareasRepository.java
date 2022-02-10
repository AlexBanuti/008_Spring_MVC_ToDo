package com.curso.tablero.domain.repository;

import java.util.Collection;

import com.curso.tablero.domain.Estados;
import com.curso.tablero.domain.Tarea;
import com.curso.tablero.exceptions.TareasException;

public interface TareasRepository {
	
	//crud (CREATE , READ, UPDATE, DELETE)
	Tarea create(Tarea tarea);
	Tarea getTareaById(Integer id);
	Collection<Tarea> getTareasByEstado(Estados estado);
	void update(Tarea tarea) throws TareasException;
	void delete(Integer id) throws TareasException;

}
