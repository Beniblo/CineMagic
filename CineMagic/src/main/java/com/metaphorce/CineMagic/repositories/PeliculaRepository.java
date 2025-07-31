package com.metaphorce.CineMagic.repositories;
import com.metaphorce.CineMagic.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    @Query("SELECT DISTINCT p FROM Pelicula p LEFT JOIN FETCH p.funciones")
    List<Pelicula> findAllWithFuncionesDistinct();

    Optional<Pelicula> findByTitulo(String titulo);
}
