package net.itinajero.app.controller;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.service.INoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/noticias")
public class NoticiasController {

    @Autowired
    private INoticiaService noticiaService;

    @GetMapping(value = "/create")
    public String crear(){
        return "noticias/formNoticia";
    }

    @PostMapping(value = "/save")
    public String guardar(Noticia noticia){
        noticiaService.guardar(noticia);

        return "noticias/formNoticia";

    }
}
