package net.itinajero.app.service;

import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.HorariosRepository;
import net.itinajero.app.repository.PeliculaRepository;
import net.itinajero.app.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class PeliculasServiceImpl implements IPeliculasService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private HorariosRepository horariosRepository;

    @Override
    public List<Pelicula> buscarTodas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula buscarPorId(int id) {

        Optional<Pelicula> optional = peliculaRepository.findById(id);

        if(optional.isPresent()){
            return optional.get();
        }

        return null;
    }

    @Override
    public void insertar(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    public List<String> buscarGeneros() {
        
        List<String> generos = new ArrayList<String>();

        generos.add("Accion");
        generos.add("Aventura");
        generos.add("Clasicas");
        generos.add("Comedia Romantica");
        generos.add("Drama");
        generos.add("Terror");
        generos.add("Infantil");
        generos.add("Accion y Aventura");
        generos.add("Romantica");

        return generos;
    }

    @Override
    public void excluir(int id) {
        peliculaRepository.deleteById(id);
    }

    @Override
    public Page<Pelicula> buscarTodas(Pageable page) {
        return peliculaRepository.findAll(page);
    }

    @Override
    public List<Pelicula> buscarPorFecha(Date fecha) {
        List<Pelicula> peliculas = null;

        List<Horario> horarios = horariosRepository.findByFecha(fecha);
        peliculas = new LinkedList<>();


        for (Horario h : horarios) {
            peliculas.add(h.getPelicula());
        }
        return peliculas;
    }

    @Override
    public List<Pelicula> buscarActivas() {
        List<Pelicula> peliculas = null;
        peliculas = peliculaRepository.findByEstatus_OrderByTitulo("Activa");
        return peliculas;
    }
}
