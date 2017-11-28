package net.itinajero.app.repository;

import net.itinajero.app.model.Detalhe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalhesRepository extends JpaRepository<Detalhe, Integer>{
}
