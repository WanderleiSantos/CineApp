package net.itinajero.app.controller;

import net.itinajero.app.model.Banner;
import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Noticia;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.service.IHorarioService;
import net.itinajero.app.service.INoticiaService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@Autowired
	private IBannersService serviceBannners;

	@Autowired
	private IBannersService serviceBanners;

	@Autowired
    private IPeliculasService peliculasService;

	@Autowired
	private IHorarioService horarioService;

	@Autowired
	private INoticiaService serviceNoticias;

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) throws ParseException {

		List<String> listaFechas = Util.getNextDays(4);
		List<Pelicula> peliculas = peliculasService.buscarTodas();

		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechas", listaFechas);

		return "home";
	}

	@RequestMapping(value="/detail/{id}/{fecha}", method = RequestMethod.GET)
	 public  String mostrarDetalhe(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") Date fecha){

		List<Horario> horarios = horarioService.buscarPorPelicula(idPelicula, fecha);
	    model.addAttribute("horarios", horarios);
	    model.addAttribute("fechaBusca", dateFormat.format(fecha));
        model.addAttribute("pelicula", peliculasService.buscarPorId(idPelicula));

		return "detail";
	 }

	 @RequestMapping(value = "/search", method = RequestMethod.POST)
	 public String buscar(@RequestParam("fecha") Date fecha, Model model) throws ParseException {

		 try {
			 Date fechaSinHora = dateFormat.parse(dateFormat.format(fecha));
			 List<String> listaFechas = Util.getNextDays(4);
			 List<Pelicula> peliculas  = peliculasService.buscarPorFecha(fechaSinHora);
			 model.addAttribute("fechas", listaFechas);
			 // Regresamos la fecha que selecciono el usuario con el mismo formato
			 model.addAttribute("fechaBusqueda",dateFormat.format(fecha));
			 model.addAttribute("peliculas", peliculas);
			 return "home";
		 } catch (ParseException e) {
			 System.out.println("Error: HomeController.buscar" + e.getMessage());
		 }
		 return "home";
     }

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/about")
	public String mostrarAcerca() {
		return "acerca";
	}

	@ModelAttribute("noticias")
	public List<Noticia> getNoticias(){
		return serviceNoticias.buscarUltimas();
	}

	@ModelAttribute("banners")
	public List<Banner> getBanners(){
		return serviceBannners.buscarActivos();
	}


}
