package com.metaphorce.CineMagic.services;

import com.metaphorce.CineMagic.entities.Funcion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface FuncionService {
    List<Funcion> obtenerTodasLasFunciones();
    List<Funcion> buscarFuncionesPorTituloPelicula(String tituloPelicula);
    Funcion actualizarHorario(Integer idFuncion, LocalDate nuevaFecha, LocalTime nuevaHora);
}