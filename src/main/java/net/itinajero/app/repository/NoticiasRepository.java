package net.itinajero.app.repository;

import net.itinajero.app.model.Noticia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
}
