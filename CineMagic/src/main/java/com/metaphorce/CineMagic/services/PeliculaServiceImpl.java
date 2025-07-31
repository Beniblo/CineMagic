package com.metaphorce.CineMagic.services;

import com.metaphorce.CineMagic.entities.Pelicula;
import com.metaphorce.CineMagic.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> obtenerTodasLasPeliculas() {
        List<Pelicula> peliculas = peliculaRepository.findAll();
        peliculas.forEach(pelicula -> pelicula.setFunciones(null));
        return peliculas;
    }

    @Override
    public Pelicula buscarPorTitulo(String titulo) {
        return peliculaRepository.findByTitulo(titulo).orElse(null);
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Pelicula actualizarPelicula(String titulo, Pelicula pelicula) {
        Pelicula existente = buscarPorTitulo(titulo);
        if (existente != null) {
            existente.setTitulo(pelicula.getTitulo());
            existente.setGenero(pelicula.getGenero());
            existente.setDuracion(pelicula.getDuracion());
            existente.setSinopsis(pelicula.getSinopsis());
            return peliculaRepository.save(existente);
        }
        return null;
    }

    @Override
    public boolean eliminarPelicula(String titulo) {
        Pelicula pelicula = buscarPorTitulo(titulo);
        if (pelicula != null) {
            peliculaRepository.delete(pelicula);
            return true;
        }
        return false;
    }
}