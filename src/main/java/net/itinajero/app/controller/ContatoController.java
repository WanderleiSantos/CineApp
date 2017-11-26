package net.itinajero.app.controller;

import net.itinajero.app.model.Contato;
import net.itinajero.app.service.IPeliculasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ContatoController {

    @Autowired
    private IPeliculasService peliculasService;

    @GetMapping(value = "contato")
    public String mostrarFormulario(@ModelAttribute Contato contato, Model model){
        model.addAttribute("generos", peliculasService.buscarGeneros());
        model.addAttribute("tipos", tipoNotificaciones());
        return "formContato";
    }

    @PostMapping(value = "contato")
    public String guardar(@ModelAttribute Contato contato){
        return "redirect:/contato";
    }

    private List<String> tipoNotificaciones(){
        List<String> tipos = new ArrayList<String>();
        tipos.add("Estrenos");
        tipos.add("Promociones");
        tipos.add("Noticia");
        tipos.add("Prevendas");
        return tipos;
    }
}
