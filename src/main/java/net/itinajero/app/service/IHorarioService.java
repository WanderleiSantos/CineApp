package net.itinajero.app.service;

import net.itinajero.app.model.Horario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IHorarioService {

    List<Horario> buscarPorPelicula(int idPelicula, Date data);

    List<Horario> buscarPorIdPelicula(int idPelicula, Date fecha);
    void insertar(Horario horario);
    List<Horario> buscarTodos();
    Page<Horario> buscarTodos(Pageable page);
    void eliminar(int idHorario);
    Horario buscarPorId(int idHorario);
}
