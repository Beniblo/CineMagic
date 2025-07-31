package com.metaphorce.CineMagic.services;
import com.metaphorce.CineMagic.entities.Pelicula;
import java.util.List;
import java.util.Optional;

public interface PeliculaService {
    List<Pelicula> obtenerTodasLasPeliculas();
    Pelicula buscarPorTitulo(String titulo);
    Pelicula crearPelicula(Pelicula pelicula);
    Pelicula actualizarPelicula(String titulo, Pelicula pelicula);
    boolean eliminarPelicula(String titulo);

}