package com.metaphorce.CineMagic.controllers;
import com.metaphorce.CineMagic.dto.AsientoResumen;
import com.metaphorce.CineMagic.entities.Asiento;
import com.metaphorce.CineMagic.enums.EstadoAsiento;
import com.metaphorce.CineMagic.repositories.AsientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/CineMagicAPI/Asiento")
public class AsientoController {

    @Autowired
    private AsientoRepository asientoRepository;

    @GetMapping("/disponiblesResumen")
    public ResponseEntity<List<Map<String, Object>>> obtenerResumenAsientosDisponibles(@RequestParam Integer idFuncion) {
        List<Asiento> disponibles = asientoRepository.findByFuncion_IdFuncionAndEstado(idFuncion, EstadoAsiento.Disponible);

        if (disponibles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<Map<String, Object>> resumen = disponibles.stream().map(asiento -> {
            Map<String, Object> datos = new HashMap<>();
            datos.put("fila", asiento.getFila().name());
            datos.put("numero", asiento.getNumeroFila().toString());
            datos.put("estado", asiento.getEstado().name());
            return datos;
        }).toList();

        return ResponseEntity.ok(resumen);
    }
}