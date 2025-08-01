package com.metaphorce.CineMagic.controllers;
import com.metaphorce.CineMagic.entities.*;
import com.metaphorce.CineMagic.enums.EstadoAsiento;
import com.metaphorce.CineMagic.enums.MedioPago;
import com.metaphorce.CineMagic.repositories.AsientoRepository;
import com.metaphorce.CineMagic.repositories.CompraRepository;
import com.metaphorce.CineMagic.repositories.DetalleCompraRepository;
import com.metaphorce.CineMagic.repositories.EspectadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/CineMagicAPI/Compra")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Autowired
    private AsientoRepository asientoRepository;

    @Autowired
    private EspectadorRepository espectadorRepository;

    @PostMapping("/realizar")
    public ResponseEntity<String> realizarCompra(@RequestBody CompraSolicitud request) {
        Optional<Espectador> espectadorOpt = espectadorRepository.findById(request.getIdEspectador());
        if (espectadorOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Espectador no encontrado");
        }

        Compra compra = new Compra();
        compra.setEspectador(espectadorOpt.get());
        compra.setFecha(LocalDateTime.now());
        compra.setTotal(request.getTotal());
        compra.setMedioPago(MedioPago.from(request.getMedioPago()));
        compra = compraRepository.save(compra);

        for (Integer idAsiento : request.getIdsAsientos()) {
            Optional<Asiento> asientoOpt = asientoRepository.findById(idAsiento);
            if (asientoOpt.isPresent()) {
                Asiento asiento = asientoOpt.get();
                if (asiento.getEstado() == EstadoAsiento.Disponible) {
                    asiento.setEstado(EstadoAsiento.Ocupado);
                    asientoRepository.save(asiento);

                    DetalleCompra detalle = new DetalleCompra();
                    detalle.setCompra(compra);
                    detalle.setAsiento(asiento);
                    detalleCompraRepository.save(detalle);
                }
            }
        }

        return ResponseEntity.ok("¡Compra realizada con éxito!");
    }


    @GetMapping("/porEspectador")
    public ResponseEntity<List<Compra>> obtenerComprasPorEspectador(@RequestParam Integer idEspectador) {
        List<Compra> compras = compraRepository.findByEspectador_IdPersona(idEspectador);
        if (compras.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(compras);
    }

    @GetMapping("/totalPorPelicula")
    public ResponseEntity<Long> obtenerTotalComprasPorPelicula(@RequestParam Integer idPelicula) {
        Long total = compraRepository.contarComprasPorPelicula(idPelicula);
        return ResponseEntity.ok(total);
    }
}

