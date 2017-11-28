package net.itinajero.app.service;

import net.itinajero.app.model.Horario;
import net.itinajero.app.repository.HorariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HorarioServiceImpl implements IHorarioService{

    @Autowired
    private HorariosRepository horariosRepository;

    @Override
    public List<Horario> buscarPorPelicula(int idPelicula, Date data) {
        return horariosRepository.findByPelicula_IdAndFechaOrderByHora(idPelicula, data);
    }
}
