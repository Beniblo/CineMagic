package com.metaphorce.CineMagic.controllers;
import com.metaphorce.CineMagic.entities.Asiento;
import com.metaphorce.CineMagic.enums.EstadoAsiento;
import com.metaphorce.CineMagic.repositories.AsientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/CineMagicAPI/Asiento")
public class AsientoController {

    @Autowired
    private AsientoRepository asientoRepository;

    @GetMapping("/disponibles")
    public ResponseEntity<List<Asiento>> obtenerAsientosDisponibles(@RequestParam Integer idFuncion) {
        List<Asiento> disponibles = asientoRepository.findByFuncion_IdFuncionAndEstado(idFuncion, EstadoAsiento.Disponible);
        if (disponibles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(disponibles);
    }
}
