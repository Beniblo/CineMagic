package com.metaphorce.CineMagic.services.impl;
import com.metaphorce.CineMagic.entities.Resenia;
import com.metaphorce.CineMagic.repositories.ReseniaRepository;
import com.metaphorce.CineMagic.services.ReseniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReseniaServiceImpl implements ReseniaService {

    @Autowired
    private ReseniaRepository reseniaRepository;

    @Override
    public Resenia guardarResenia(Resenia resenia) {
        return reseniaRepository.save(resenia);
    }

    @Override
    public List<Resenia> obtenerReseniasPorEspectador(Integer idEspectador) {
        return reseniaRepository.findAll().stream()
                .filter(r -> r.getEspectador().getIdPersona().equals(idEspectador))
                .toList();
    }

    @Override
    public List<Resenia> obtenerReseniasPorPelicula(Integer idPelicula) {
        return reseniaRepository.findAll().stream()
                .filter(r -> r.getPelicula().getIdPelicula().equals(idPelicula))
                .toList();
    }
}
