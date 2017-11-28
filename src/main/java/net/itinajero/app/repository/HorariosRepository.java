package net.itinajero.app.repository;

import net.itinajero.app.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {
}
