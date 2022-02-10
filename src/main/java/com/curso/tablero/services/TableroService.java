package com.curso.tablero.services;

import java.util.Collection;

import com.curso.tablero.domain.Tarea;
import com.curso.tablero.exceptions.TareasException;

public interface TableroService {

	void crearTarea(Tarea t) throws TareasException;
	Tarea getTarea(Integer id);
	Collection<Tarea> getTareasToDo();
	Collection<Tarea> getTareasInProgress();
	Collection<Tarea> getTareasDone();
	void moverAToDo(Integer id) throws TareasException;;
	void moverAInProgress(Integer id) throws TareasException;;
	void moverADone(Integer id) throws TareasException;
	void borrarTarea(Integer id) throws TareasException;
}
