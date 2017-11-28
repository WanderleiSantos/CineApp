package net.itinajero.app.service;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaServiceImpl implements INoticiaService {

    @Autowired
    private NoticiasRepository noticiasRepo;

    @Override
    public List<Noticia> buscarUltimas() {
        List<Noticia> noticias = noticiasRepo.findTop3ByStatusOrderByIdDesc("Activa");
        return noticias;
    }

    @Override
    public void guardar(Noticia noticia) {
        noticiasRepo.save(noticia);
    }

    @Override
    public List<Noticia> buscarTodas() {
        return noticiasRepo.findAll();
    }

    @Override
    public void eliminar(int idNoticia) {
        noticiasRepo.deleteById(idNoticia);
    }


    @Override
    public Noticia buscarPorId(int idNoticia) {
        Optional<Noticia> optional = noticiasRepo.findById(idNoticia);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}
