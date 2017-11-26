package net.itinajero.app.controller;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.*;

import static net.itinajero.app.util.Util.guardarImagem;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private IPeliculasService peliculasService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/create")
    public String crear(@ModelAttribute Pelicula pelicula, Model model){
        model.addAttribute("generos", peliculasService.buscarGeneros());
        return "peliculas/formPelicula";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes redirectAttributes,
                          @RequestParam("arquivoImagem") MultipartFile multipartFile, HttpServletRequest httpServletRequest){

        if (!multipartFile.isEmpty()) {
            String nomeImagem = Util.guardarImagem(multipartFile, httpServletRequest);
            pelicula.setImagem(nomeImagem);
        }

        peliculasService.insertar(pelicula);
        redirectAttributes.addFlashAttribute("mensagem","Registro salvo com sucesso");

        return "redirect:/peliculas/index";
    }

    @GetMapping("/index")
    public String mostrarIndex(Model model){
        List<Pelicula> peliculaList = peliculasService.buscarTodas();
        model.addAttribute("peliculas", peliculaList);
        return "peliculas/listPeliculas";
    }



}
