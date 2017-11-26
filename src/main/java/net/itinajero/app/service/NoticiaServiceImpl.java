package net.itinajero.app.service;

import net.itinajero.app.model.Noticia;
import org.springframework.stereotype.Service;

@Service
public class NoticiaServiceImpl implements INoticiaService {

    public NoticiaServiceImpl() {
        System.out.println("Creando una instancia de la clase NoticiasServiceImpl");
    }

    @Override
    public void guardar(Noticia noticia) {
        System.out.println("Guadando el objeto " + noticia + " en la base de datos.");
    }
}
