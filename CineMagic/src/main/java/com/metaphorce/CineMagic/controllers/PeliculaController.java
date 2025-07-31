package com.metaphorce.CineMagic.controllers;
import com.metaphorce.CineMagic.entities.Pelicula;
import com.metaphorce.CineMagic.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CineMagicAPI/Pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/listar")
    public List<Pelicula> obtenerTodasLasPeliculas() {
        return peliculaService.obtenerTodasLasPeliculas();
    }

    @GetMapping("/buscar")
    public ResponseEntity<Pelicula> buscarPorTitulo(@RequestParam String titulo) {
        Pelicula pelicula = peliculaService.buscarPorTitulo(titulo);
        if (pelicula != null) {
            return ResponseEntity.ok(pelicula);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Pelicula> crearPelicula(@RequestBody Pelicula pelicula) {
        Pelicula nueva = peliculaService.crearPelicula(pelicula);
        return ResponseEntity.ok(nueva);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Pelicula> actualizarPelicula(@RequestParam String titulo, @RequestBody Pelicula datosActualizados) {
        Pelicula actualizada = peliculaService.actualizarPelicula(titulo, datosActualizados);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<Void> eliminarPelicula(@RequestParam String titulo) {
        boolean eliminada = peliculaService.eliminarPelicula(titulo);
        if (eliminada) {
            return ResponseEntity.noContent().build(); // 204
        } else {
            return ResponseEntity.notFound().build(); // 404
        }
    }
}
