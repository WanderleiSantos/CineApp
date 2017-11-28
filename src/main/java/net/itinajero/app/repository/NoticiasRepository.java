package net.itinajero.app.repository;

import net.itinajero.app.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {

    List<Noticia> findBy();

    List<Noticia> findByStatus(String estatus);

    List<Noticia> findByFecha(Date fecha);

    List<Noticia> findByStatusAndFecha(String estatus, Date fecha);

    List<Noticia> findByStatusOrFecha(String estatus, Date fecha);

    List<Noticia> findByFechaBetween(Date fecha1, Date fecha2);

    List<Noticia> findByIdBetween(int n1, int n2);

    public List<Noticia> findTop3ByStatusOrderByIdDesc(String estatus);

}
