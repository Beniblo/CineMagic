package com.metaphorce.CineMagic.services.impl;
import com.metaphorce.CineMagic.entities.Funcion;
import com.metaphorce.CineMagic.repositories.FuncionRepository;
import com.metaphorce.CineMagic.services.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class FuncionServiceImpl implements FuncionService {

    @Autowired
    private FuncionRepository funcionRepository;

    @Override
    public List<Funcion> obtenerTodasLasFunciones() {
        return funcionRepository.findAll();
    }

    @Override
    public List<Funcion> buscarFuncionesPorTituloPelicula(String tituloPelicula) {
        return funcionRepository.findByPelicula_Titulo(tituloPelicula);
    }

    @Override
    public Funcion actualizarHorario(Integer idFuncion, LocalDate nuevaFecha, LocalTime nuevaHora) {
        Funcion funcion = funcionRepository.findById(idFuncion)
                .orElseThrow(() -> new RuntimeException("Función no encontrada"));

        funcion.setFecha(nuevaFecha);
        funcion.setHora(nuevaHora);

        return funcionRepository.save(funcion);
    }
}