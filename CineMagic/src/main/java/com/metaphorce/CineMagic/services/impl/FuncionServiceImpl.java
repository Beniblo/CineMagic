package com.metaphorce.CineMagic.services.impl;
import com.metaphorce.CineMagic.entities.Funcion;
import com.metaphorce.CineMagic.repositories.FuncionRepository;
import com.metaphorce.CineMagic.services.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}