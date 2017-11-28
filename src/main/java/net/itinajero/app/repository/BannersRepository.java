package net.itinajero.app.repository;

import net.itinajero.app.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannersRepository extends JpaRepository<Banner, Integer> {

    public List<Banner> findByEstatusOrderByIdDesc(String estatus);
}
