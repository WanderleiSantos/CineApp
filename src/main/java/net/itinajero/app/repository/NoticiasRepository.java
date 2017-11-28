package net.itinajero.app.repository;

import net.itinajero.app.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {

    List<Noticia> findByStatus(String status);

    List<Noticia> findByFecha(Date data);

    List<Noticia> findByStatusAndFecha(String status, Date data);
}
