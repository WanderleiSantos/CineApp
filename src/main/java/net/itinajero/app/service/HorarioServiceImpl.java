package net.itinajero.app.service;

import net.itinajero.app.model.Horario;
import net.itinajero.app.repository.HorariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HorarioServiceImpl implements IHorarioService{

    @Autowired
    private HorariosRepository horariosRepository;

    @Override
    public List<Horario> buscarPorPelicula(int idPelicula, Date data) {
        return horariosRepository.findByPelicula_IdAndFechaOrderByHora(idPelicula, data);
    }

    @Override
    public List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha) {
        return horariosRepository.findByPelicula_IdAndFechaOrderByHora(idPelicula,fecha);
    }

    @Override
    public void insertar(Horario horario) {
        horariosRepository.save(horario);
    }

    @Override
    public List<Horario> buscarTodos() {
        return horariosRepository.findAll();
    }

    @Override
    public Page<Horario> buscarTodos(Pageable page) {
        return horariosRepository.findAll(page);
    }

    @Override
    public void eliminar(int idHorario) {
        horariosRepository.deleteById(idHorario);
    }

    @Override
    public Horario buscarPorId(int idHorario) {
        Optional<Horario> optional = horariosRepository.findById(idHorario);
        if (optional.isPresent())
            return optional.get();
        return null;
    }
}
