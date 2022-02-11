package com.curso.tablero.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.curso.tablero.domain.Tarea;
import com.curso.tablero.exceptions.TareasException;
import com.curso.tablero.services.TableroService;

@Controller
public class TableroController {

	@Autowired
	private TableroService tableroService;  // Interface  inyectas una instancia de la clase que implemengta el interfaz
	
	//get  /tablero
	@GetMapping("/tablero")
	public String mostrarTablero(Model model) {
		
		model.addAttribute("columnaToDo", tableroService.getTareasToDo()); //columnatodo (xml), tableroService (desde la inyeccion de arriba), getTarea (metodo del repository)
		model.addAttribute("columnaInProgress", tableroService.getTareasInProgress());
		model.addAttribute("columnaDone", tableroService.getTareasDone());
		
		return "tablero";
	}
	
	
	// get  /tablero/nueva-tarea 
	
	@GetMapping("/tablero/{id}/{nuevoestado}")
	public String cambiarEstado(
		@PathVariable("id") int id,
		@PathVariable("nuevoestado") String nuevoEstado) throws TareasException{
			
			switch(nuevoEstado) {
			case "TODO":
				tableroService.moverAToDo(id);
				break;
			case "INPROGRESS":
			 	tableroService.moverAInProgress(id);
			 	break;
			case "DONE":
				tableroService.moverADone(id);
				break;
			default:
				throw new TareasException("tareas.cambioEstado.error.noExisteEstado", nuevoEstado);
			}
			
			return "redirect:/tablero";
		}
	
	// get /tablero/nueva-tarea
    @GetMapping("/tablero/crear-tarea")
    public String getCrearNuevaTareaFormulario(Model model) {
        Tarea tarea = new Tarea();
        model.addAttribute("nuevaTarea", tarea);
        return "crear-tarea";
    }
    // post /tablero/nueva-tarea
    @PostMapping("/tablero/crear-tarea")
    public String crearNuevaTarea(@ModelAttribute("nuevaTarea") @Valid Tarea nueva, BindingResult bindingResult) throws TareasException {
           
        if (bindingResult.hasErrors()) {
            return "crear-tarea";
        }
        tableroService.crearTarea(nueva);
        return "redirect:/tablero";
    }
	
		// get /tablero/tarea/{id}/{nuevoEstado}

	 @ExceptionHandler(TareasException.class)

	    public ModelAndView handleException( TareasException exception) {

	         ModelAndView mav = new ModelAndView();

	         mav.addObject("claveMensage",exception.getKeyMensaje());
	         mav.addObject("argsMensage", exception.getArgs());
	         exception.printStackTrace();
	         mav.setViewName("tareas-exception");
	         return mav;
	    }

}
	

