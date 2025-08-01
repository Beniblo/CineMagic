package com.metaphorce.CineMagic.services.impl;
import com.metaphorce.CineMagic.entities.Calificacion;
import com.metaphorce.CineMagic.repositories.CalificacionRepository;
import com.metaphorce.CineMagic.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CalificacionServiceImpl implements CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Override
    public Calificacion guardarCalificacion(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public List<Calificacion> obtenerCalificacionesPorPelicula(Integer idPelicula) {
        return calificacionRepository.findAll().stream()
                .filter(c -> c.getPelicula().getIdPelicula().equals(idPelicula))
                .toList();
    }
}
