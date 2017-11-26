package net.itinajero.app.controller;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	private IBannersService serviceBanners;

	@Autowired
    private IPeliculasService peliculasService;

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
		model.addAttribute("banners", serviceBanners.buscarTodos());

		return "home";
	}

	@RequestMapping(value="/detail/{id}/{fecha}", method = RequestMethod.GET)
	 public  String mostrarDetalhe(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha){

        model.addAttribute("pelicula", peliculasService.buscarPorId(idPelicula));

		return "detail";
	 }

	 @RequestMapping(value = "/search", method = RequestMethod.POST)
	 public String buscar(@RequestParam("fecha") String fecha, Model model) throws ParseException {

         List<String> listaFechas = Util.getNextDays(4);
         List<Pelicula> peliculas = peliculasService.buscarTodas();


         model.addAttribute("fechaBusqueda", fecha);
         model.addAttribute("peliculas", peliculas);
         model.addAttribute("fechas", listaFechas);

		 model.addAttribute("banners", serviceBanners.buscarTodos());

	     return "home";
     }
}
