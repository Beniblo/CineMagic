package com.metaphorce.CineMagic.services;
import com.metaphorce.CineMagic.entities.Calificacion;
import java.util.List;

public interface CalificacionService {
    Calificacion guardarCalificacion(Calificacion calificacion);
    List<Calificacion> obtenerCalificacionesPorPelicula(Integer idPelicula);
}