package com.metaphorce.CineMagic.services;
import com.metaphorce.CineMagic.entities.Resenia;
import java.util.List;

public interface ReseniaService {
    Resenia guardarResenia(Resenia resenia);
    List<Resenia> obtenerReseniasPorEspectador(Integer idEspectador);
    List<Resenia> obtenerReseniasPorPelicula(Integer idPelicula);
}
