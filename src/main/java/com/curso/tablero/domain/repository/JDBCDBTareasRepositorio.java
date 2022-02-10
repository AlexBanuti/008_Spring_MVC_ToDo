package com.curso.tablero.domain.repository;

import java.util.Collection;

import com.curso.tablero.domain.Estados;
import com.curso.tablero.domain.Tarea;
import com.curso.tablero.exceptions.TareasException;

public class JDBCDBTareasRepositorio implements TareasRepository {

	@Override
	public Tarea create(Tarea tarea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tarea getTareaById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Tarea> getTareasByEstado(Estados estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tarea tarea) throws TareasException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) throws TareasException {
		// TODO Auto-generated method stub

	}

}
