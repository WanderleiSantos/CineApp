package net.itinajero.app.controller;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.service.INoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping(value = "/noticias")
public class NoticiasController {

    @Autowired
    private INoticiaService serviceNoticias;


    @GetMapping(value = "/index")
    public String mostrarIndex(Model model) {
        List<Noticia> listaNoticias = serviceNoticias.buscarTodas();
        model.addAttribute("noticias", listaNoticias);
        return "noticias/listNoticias";
    }

    @GetMapping(value = "/create")
    public String crear(@ModelAttribute Noticia noticia) {
        return "noticias/formNoticia";
    }

    @PostMapping(value = "/save")
    public String guardar(@ModelAttribute Noticia noticia, BindingResult result, Model model,
                          RedirectAttributes attributes) {
        serviceNoticias.guardar(noticia);
        attributes.addFlashAttribute("msg", "Los datos de la noticia fueron guardados!");
        return "redirect:/noticias/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String eliminar(@PathVariable("id") int idNoticia, RedirectAttributes attributes) {
        serviceNoticias.eliminar(idNoticia);
        attributes.addFlashAttribute("msg", "La noticia fue eliminada!.");
        return "redirect:/noticias/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String editar(@PathVariable("id") int idNoticia, Model model) {
        Noticia noticia = serviceNoticias.buscarPorId(idNoticia);
        model.addAttribute("noticia", noticia);
        return "noticias/formNoticia";
    }

}