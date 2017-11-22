package net.itinajero.app.service;

import net.itinajero.app.model.Pelicula;

import java.util.List;

public interface IPeliculasService {

    List<Pelicula> buscarTodas();

    Pelicula buscarPorId(int id);

}
