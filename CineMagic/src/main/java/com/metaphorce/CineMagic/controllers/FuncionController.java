package com.metaphorce.CineMagic.controllers;

import com.metaphorce.CineMagic.entities.Funcion;
import com.metaphorce.CineMagic.repositories.FuncionRepository;
import com.metaphorce.CineMagic.services.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/CineMagicAPI/Funcion")
public class FuncionController {

    @Autowired
    private FuncionRepository funcionRepository;

    @Autowired
    private FuncionService funcionService;

    @GetMapping("/porPelicula")
    public ResponseEntity<List<Funcion>> obtenerFuncionesPorPelicula(@RequestParam Integer idPelicula) {
        List<Funcion> funciones = funcionRepository.findByPelicula_IdPelicula(idPelicula);
        if (funciones.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funciones);
    }

    @GetMapping("/listar")
    public List<Funcion> obtenerTodasLasFunciones() {
        return funcionRepository.findAll();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Funcion>> buscarFuncionesPorTituloPelicula(@RequestParam String tituloPelicula) {
        List<Funcion> funciones = funcionService.buscarFuncionesPorTituloPelicula(tituloPelicula);
        if (funciones.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(funciones);
    }

    @PutMapping("/{id}/horario")
    public ResponseEntity<?> actualizarHorarioFuncion(
            @PathVariable Integer id,
            @RequestParam String fecha,
            @RequestParam String hora) {
        try {
            // Parseamos los strings a LocalDate y LocalTime
            LocalDate nuevaFecha = LocalDate.parse(fecha);
            LocalTime nuevaHora = LocalTime.parse(hora);

            Funcion actualizada = funcionService.actualizarHorario(id, nuevaFecha, nuevaHora);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al actualizar horario: " + e.getMessage());
        }
    }
}
