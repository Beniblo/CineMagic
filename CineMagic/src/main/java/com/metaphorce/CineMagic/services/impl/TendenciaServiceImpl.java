package com.metaphorce.CineMagic.services.impl;
import com.metaphorce.CineMagic.dto.TendenciaPeliculaDTO;
import com.metaphorce.CineMagic.entities.Calificacion;
import com.metaphorce.CineMagic.entities.DetalleCompra;
import com.metaphorce.CineMagic.entities.Pelicula;
import com.metaphorce.CineMagic.repositories.CalificacionRepository;
import com.metaphorce.CineMagic.repositories.DetalleCompraRepository;
import com.metaphorce.CineMagic.services.TendenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TendenciaServiceImpl implements TendenciaService {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Autowired
    private CalificacionRepository calificacionRepository;

    @Override
    public List<TendenciaPeliculaDTO> obtenerRankingTendencia() {
        // Mapear compras por película
        Map<Pelicula, Long> comprasPorPelicula = detalleCompraRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        d -> d.getAsiento().getFuncion().getPelicula(),
                        Collectors.counting()
                ));

        // Mapear calificaciones promedio por película
        Map<Pelicula, Double> calificacionesPromedio = calificacionRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Calificacion::getPelicula,
                        Collectors.averagingInt(Calificacion::getEstrellas)
                ));

        // Unir ambos mapas
        Set<Pelicula> todasLasPeliculas = new HashSet<>();
        todasLasPeliculas.addAll(comprasPorPelicula.keySet());
        todasLasPeliculas.addAll(calificacionesPromedio.keySet());

        return todasLasPeliculas.stream()
                .map(p -> new TendenciaPeliculaDTO(
                        p.getIdPelicula(),
                        p.getTitulo(),
                        comprasPorPelicula.getOrDefault(p, 0L),
                        Math.round(calificacionesPromedio.getOrDefault(p, 0.0) * 10.0) / 10.0
                ))
                .sorted(Comparator.comparing(TendenciaPeliculaDTO::getTotalCompras).reversed())
                .collect(Collectors.toList());
    }
}
