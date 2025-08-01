package com.metaphorce.CineMagic.services;

import com.metaphorce.CineMagic.entities.Funcion;
import java.util.List;

public interface FuncionService {
    List<Funcion> obtenerTodasLasFunciones();
    List<Funcion> buscarFuncionesPorTituloPelicula(String tituloPelicula);
}