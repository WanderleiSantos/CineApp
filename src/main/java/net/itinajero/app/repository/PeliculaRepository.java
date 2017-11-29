package net.itinajero.app.repository;

import net.itinajero.app.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

    public List<Pelicula> findByEstatus_OrderByTitulo(String estatus);
}
