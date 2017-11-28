package net.itinajero.app.service;

import net.itinajero.app.model.Noticia;

import java.util.List;

public interface INoticiaService {

    void guardar(Noticia noticia);
    List<Noticia> buscarUltimas();
    List<Noticia> buscarTodas();
    void eliminar(int idNoticia);
    Noticia buscarPorId(int idNoticia);
}
