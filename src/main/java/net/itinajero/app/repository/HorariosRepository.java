package net.itinajero.app.repository;

import net.itinajero.app.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {

    public List<Horario> findByPelicula_IdAndFechaOrderByHora(int IdPelicula, Date data);

    @Query("select h from Horario h where h.fecha = :fecha and pelicula.estatus='Activa' order by pelicula.id asc")
    public List<Horario> findByFecha(@Param("fecha") Date fecha);
}
