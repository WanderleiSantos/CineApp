package net.itinajero.app.service;

import net.itinajero.app.model.Horario;

import java.util.Date;
import java.util.List;

public interface IHorarioService {
    List<Horario> buscarPorPelicula(int idPelicula, Date data);
}
