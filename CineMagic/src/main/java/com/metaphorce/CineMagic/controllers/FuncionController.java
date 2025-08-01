package com.metaphorce.CineMagic.controllers;
import com.metaphorce.CineMagic.entities.Funcion;
import com.metaphorce.CineMagic.repositories.FuncionRepository;
import com.metaphorce.CineMagic.services.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/CineMagicAPI/Funcion")
public class FuncionController {

    @Autowired
    private FuncionRepository funcionRepository;

    @Autowired
    private FuncionService funcionService; // <-- ¡Esto faltaba!

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
}
