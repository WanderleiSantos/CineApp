package net.itinajero.app.repository;

import net.itinajero.app.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {

    public List<Horario> findByPelicula_IdAndFechaOrderByHora(int IdPelicula, Date data);
}
