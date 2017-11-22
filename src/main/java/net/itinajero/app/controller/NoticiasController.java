package net.itinajero.app.controller;

import net.itinajero.app.model.Noticia;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/noticias")
public class NoticiasController {

    @GetMapping(value = "/create")
    public String crear(){
        return "noticias/formNoticia";
    }

    @PostMapping(value = "/save")
    public String guardar(@RequestParam("titulo") String titulo,
                          @RequestParam("status") String status,
                          @RequestParam("detalhe") String detalhe){

        Noticia noticia = new Noticia();

        noticia.setTitulo(titulo);
        noticia.setDetalhe(detalhe);
        noticia.setStatus(status);

        return "noticias/formNoticia";

    }
}
