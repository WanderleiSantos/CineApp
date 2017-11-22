package net.itinajero.app.service;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.util.Util;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculasServiceImpl implements IPeliculasService{

    private List<Pelicula> peliculas = new ArrayList<Pelicula>();

    public PeliculasServiceImpl() {

        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");

        try {

            Pelicula pelicula = new Pelicula();

            pelicula.setId(10);
            pelicula.setTitulo("Kong");
            pelicula.setDuracion(160);
            pelicula.setClasificacion("A");
            pelicula.setGenero("Drama");
            pelicula.setEstatus("Activa");
            pelicula.setFechaEstreno(formater.parse("10-06-2017"));

            Pelicula pelicula2 = new Pelicula();

            pelicula2.setId(11);
            pelicula2.setTitulo("Monstros");
            pelicula2.setDuracion(160);
            pelicula2.setClasificacion("A");
            pelicula2.setGenero("Drama");
            pelicula2.setEstatus("Activa");
            pelicula2.setFechaEstreno(formater.parse("10-06-2017"));

            peliculas.add(pelicula);
            peliculas.add(pelicula2);

        } catch (ParseException ex){

        }
    }

    @Override
    public List<Pelicula> buscarTodas() {
        return peliculas;
    }

    @Override
    public Pelicula buscarPorId(int id) {

        for (Pelicula p : peliculas){
            if(p.getId() == id){
                return p;
            }
        }

        return null;
    }
}
