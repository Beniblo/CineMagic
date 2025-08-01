package com.metaphorce.CineMagic.controllers;
import com.metaphorce.CineMagic.dto.CalificacionDTO;
import com.metaphorce.CineMagic.dto.CalificacionRespuestaDTO;
import com.metaphorce.CineMagic.entities.Calificacion;
import com.metaphorce.CineMagic.repositories.EspectadorRepository;
import com.metaphorce.CineMagic.repositories.PeliculaRepository;
import com.metaphorce.CineMagic.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/CineMagicAPI/Calificacion")
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private EspectadorRepository espectadorRepository;

    @GetMapping("/porPelicula")
    public ResponseEntity<?> obtenerPorPelicula(@RequestParam Integer idPelicula) {
        var lista = calificacionService.obtenerCalificacionesPorPelicula(idPelicula);

        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }

        var respuesta = lista.stream().map(c -> new CalificacionRespuestaDTO(
                c.getEstrellas(),
                c.getFecha(),
                c.getEspectador().getNombre(), // ← solo el nombre
                c.getPelicula().getTitulo()    // ← solo el título
        )).toList();

        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody CalificacionDTO dto) {
        var pelicula = peliculaRepository.findById(dto.getIdPelicula()).orElse(null);
        var espectador = espectadorRepository.findById(dto.getIdEspectador()).orElse(null);

        if (pelicula == null || espectador == null) {
            return ResponseEntity.badRequest().body("Datos inválidos: Película o Espectador no existen");
        }

        Calificacion calificacion = new Calificacion();
        calificacion.setPelicula(pelicula);
        calificacion.setEspectador(espectador);
        calificacion.setEstrellas(dto.getEstrellas());
        calificacion.setFecha(LocalDate.now());

        calificacionService.guardarCalificacion(calificacion);
        return ResponseEntity.ok("¡Calificación registrada!");
    }
}
