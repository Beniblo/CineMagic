package com.metaphorce.CineMagic.services;
import com.metaphorce.CineMagic.dto.TendenciaPeliculaDTO;
import java.util.List;

public interface TendenciaService {
    List<TendenciaPeliculaDTO> obtenerRankingTendencia();
}
