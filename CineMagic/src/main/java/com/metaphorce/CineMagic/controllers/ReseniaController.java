package com.metaphorce.CineMagic.controllers;
import com.metaphorce.CineMagic.dto.ReseniaDTO;
import com.metaphorce.CineMagic.entities.Resenia;
import com.metaphorce.CineMagic.repositories.EspectadorRepository;
import com.metaphorce.CineMagic.repositories.PeliculaRepository;
import com.metaphorce.CineMagic.services.ReseniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/CineMagicAPI/Resenia")
public class ReseniaController {

    @Autowired
    private ReseniaService reseniaService;

    @Autowired
    private EspectadorRepository espectadorRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody ReseniaDTO dto) {
        var espectador = espectadorRepository.findById(dto.getIdEspectador()).orElse(null);
        var pelicula = peliculaRepository.findById(dto.getIdPelicula()).orElse(null);

        if (espectador == null || pelicula == null) {
            return ResponseEntity.badRequest().body("Película o espectador no válidos");
        }

        Resenia resenia = new Resenia();
        resenia.setEspectador(espectador);
        resenia.setPelicula(pelicula);
        resenia.setContenido(dto.getContenido());
        resenia.setFecha(LocalDate.now());

        reseniaService.guardarResenia(resenia);
        return ResponseEntity.ok("¡Reseña guardada con éxito!");
    }

    @GetMapping("/porEspectador")
    public ResponseEntity<List<Resenia>> obtenerPorEspectador(@RequestParam Integer idEspectador) {
        List<Resenia> lista = reseniaService.obtenerReseniasPorEspectador(idEspectador);
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }

    @GetMapping("/porPelicula")
    public ResponseEntity<List<Resenia>> obtenerPorPelicula(@RequestParam Integer idPelicula) {
        List<Resenia> lista = reseniaService.obtenerReseniasPorPelicula(idPelicula);
        return lista.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(lista);
    }
}
