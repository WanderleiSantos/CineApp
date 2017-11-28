package net.itinajero.app.service;

import net.itinajero.app.model.Pelicula;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IPeliculasService {

    List<Pelicula> buscarTodas();

    Pelicula buscarPorId(int id);

    void insertar(Pelicula pelicula);

    List<String> buscarGeneros();

    void excluir(int id);

    Page<Pelicula> buscarTodas(Pageable page);

    List<Pelicula> buscarPorFecha(Date fecha);

}
