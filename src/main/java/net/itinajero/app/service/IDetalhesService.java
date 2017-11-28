package net.itinajero.app.service;

import net.itinajero.app.model.Detalhe;

public interface IDetalhesService {
    void insertar(Detalhe detalhe);
    void exluir(int id);
}
