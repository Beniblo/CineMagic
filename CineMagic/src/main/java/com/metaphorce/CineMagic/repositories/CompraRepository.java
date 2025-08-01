package com.metaphorce.CineMagic.repositories;

import com.metaphorce.CineMagic.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

    List<Compra> findByEspectador_IdPersona(Integer idEspectador);

    @Query("SELECT COUNT(dc) FROM DetalleCompra dc WHERE dc.asiento.funcion.pelicula.idPelicula = :idPelicula")
    Long contarComprasPorPelicula(Integer idPelicula);
}

