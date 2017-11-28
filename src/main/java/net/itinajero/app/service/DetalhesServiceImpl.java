package net.itinajero.app.service;

import net.itinajero.app.model.Detalhe;
import net.itinajero.app.repository.DetalhesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalhesServiceImpl implements IDetalhesService {

    @Autowired
    private DetalhesRepository detalhesRepository;

    @Override
    public void insertar(Detalhe detalhe) {
        detalhesRepository.save(detalhe);
    }

    @Override
    public void exluir(int id) {
        detalhesRepository.deleteById(id);
    }
}
