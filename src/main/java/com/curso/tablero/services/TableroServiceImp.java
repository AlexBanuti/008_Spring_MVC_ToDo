package com.curso.tablero.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.tablero.domain.Estados;
import com.curso.tablero.domain.Tarea;
import com.curso.tablero.domain.repository.TareasRepository;
import com.curso.tablero.exceptions.TareasException;

@Service
public class TableroServiceImp implements TableroService {

	@Autowired
	private TareasRepository tareasRepository;
	
	
	@Override
	public void crearTarea(Tarea t) throws TareasException {
		tareasRepository.create(t);
	}

	@Override
	public Tarea getTarea(Integer id) {
		return tareasRepository.getTareaById(id);
	}

	@Override
	public Collection<Tarea> getTareasToDo() {
		return tareasRepository.getTareasByEstado(Estados.TODO);
	}

	@Override
	public Collection<Tarea> getTareasInProgress() {
		return tareasRepository.getTareasByEstado(Estados.INPROGRESS);
	}

	@Override
	public Collection<Tarea> getTareasDone() {
		return tareasRepository.getTareasByEstado(Estados.DONE);
	}

	

	@Override
	public void moverAInProgress(Integer id) throws TareasException {
		cambiarEstado(id, Estados.INPROGRESS);

	}

	@Override
	public void moverADone(Integer id) throws TareasException {
		cambiarEstado(id, Estados.DONE);

	}
	
	@Override
	public void moverAToDo(Integer id) throws TareasException {
		cambiarEstado(id, Estados.TODO);

	}
	
	private void cambiarEstado(Integer id, Estados estado ) throws TareasException {
		Tarea t = tareasRepository.getTareaById(id);
		if(t == null) {
		 //throw new TareasException("La tarea a modificar no existe");
		throw new TareasException("tareas.cambioEstado.error.noExisteTarea", id.toString());
		}
		if( t.getEstado() != estado ) {
		t.setEstado(estado);
		tareasRepository.update(t);
		}
	}

	@Override
	public void borrarTarea(Integer id) throws TareasException {
		tareasRepository.delete(id);
	}

}
