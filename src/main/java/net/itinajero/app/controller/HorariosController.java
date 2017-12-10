package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.itinajero.app.service.IHorarioService;
import net.itinajero.app.validador.HorarioValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/horarios")
public class HorariosController {

	@Autowired
	private IPeliculasService servicePeliculas;


	@Autowired
	private IHorarioService serviceHorarios;

	@GetMapping(value = "/index")
	public String mostrarIndex(Model model) {
		List<Horario> listaHorarios = serviceHorarios.buscarTodos();
		model.addAttribute("horarios", listaHorarios);
		return "horarios/listHorarios";
	}


	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Horario> listaHorarios = serviceHorarios.buscarTodos(page);
		model.addAttribute("horarios", listaHorarios);
		return "horarios/listHorarios";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Horario horario) {
		return "horarios/formHorario";
	}

/*	@PostMapping(value = "/save")
	public String guardar(@Valid @ModelAttribute Horario horario, BindingResult result, Model model, RedirectAttributes attributes) {

		if (result.hasErrors()){
			List<Pelicula> listaPeliculas = servicePeliculas.buscarActivas();
			model.addAttribute("peliculas", listaPeliculas);
			return "horarios/formHorario";
		}

		serviceHorarios.insertar(horario);
		attributes.addFlashAttribute("msg", "El horario fue guardado!");
		//return "redirect:/horarios/index";
		return "redirect:/horarios/indexPaginate";
	}*/

	@PostMapping(value = "/save")
	public @ResponseBody Horario guardar(Horario horario, BindingResult result, Model model, RedirectAttributes attributes) {

		/*if (result.hasErrors()){
			List<Pelicula> listaPeliculas = servicePeliculas.buscarActivas();
			model.addAttribute("peliculas", listaPeliculas);
			return "horarios/formHorario";
		}*/

		serviceHorarios.insertar(horario);
		/*attributes.addFlashAttribute("msg", "El horario fue guardado!");*/
		return horario;
	}


	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idHorario, Model model) {
		Horario horario = serviceHorarios.buscarPorId(idHorario);
		model.addAttribute("horario", horario);
		return "horarios/formHorario";
	}


    @ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable("id") int idHorario) {
		serviceHorarios.eliminar(idHorario);
		return "horarios/indexPaginate";
	}


	@ModelAttribute("peliculas")
	public List<Pelicula> getPeliculas(){
		return servicePeliculas.buscarActivas();
	}


	@InitBinder("horario")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.addValidators(new HorarioValidator());
	}
	
}
