package com.metaphorce.CineMagic.controllers;
import com.metaphorce.CineMagic.dto.TendenciaPeliculaDTO;
import com.metaphorce.CineMagic.services.TendenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/CineMagicAPI/Tendencia")
public class TendenciaController {

    @Autowired
    private TendenciaService tendenciaService;

    @GetMapping("/ranking")
    public ResponseEntity<List<TendenciaPeliculaDTO>> obtenerRanking() {
        List<TendenciaPeliculaDTO> ranking = tendenciaService.obtenerRankingTendencia();
        return ranking.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(ranking);
    }
}
