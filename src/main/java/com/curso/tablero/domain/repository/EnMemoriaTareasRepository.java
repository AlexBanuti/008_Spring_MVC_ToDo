package com.curso.tablero.domain.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.curso.tablero.domain.Estados;
import com.curso.tablero.domain.Tarea;
import com.curso.tablero.exceptions.TareasException;

@Repository
public class EnMemoriaTareasRepository implements TareasRepository {

	private Map<Integer, Tarea> tareas = new HashMap<Integer, Tarea>();
	
	private static int  contadorId = 2;
	
	EnMemoriaTareasRepository() {

        tareas.put(1, new Tarea(1, "Tarea 1","Lo que sea"));
        tareas.put(2, new Tarea(2, "Tarea 2","Lo que sea 2"));
        
    }
	
	
	@Override
	public Tarea create(Tarea tarea) {
		contadorId ++;
		tarea.setId(contadorId);
		return tarea;
	}

	/**
	 * Retorna la tarea por el id
	 * Si no exite retorna null
	 */
	@Override
	public Tarea getTareaById(Integer id) {	
		return tareas.get(id);
	}

	@Override
	public Collection<Tarea> getTareasByEstado(Estados estado) {
		List<Tarea> lista = new ArrayList<Tarea>();
		for(Tarea t : tareas.values()) {
			if(t.getEstado() == estado) {
				lista.add(t);
			}
		}
		return lista;
	}

	@Override
	public void update(Tarea tarea) throws TareasException {
		//primero validar que existe
		if( ! tareas.containsKey(tarea.getId())) {
			throw new TareasException("La tarea a modificar no existe");
		}
		tareas.put(tarea.getId(), tarea);
	}

	@Override
	public void delete(Integer id) throws TareasException {
		//primero validar que existe
		Tarea t = getTareaById(id);
		if (t == null) {
			throw new TareasException("La tarea a borrar no existe");
		}
		tareas.remove(id);

	}

}
