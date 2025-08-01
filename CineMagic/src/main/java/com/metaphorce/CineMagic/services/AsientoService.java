package com.metaphorce.CineMagic.services;
import com.metaphorce.CineMagic.entities.Asiento;
import com.metaphorce.CineMagic.enums.EstadoAsiento;
import java.util.List;
import java.util.Optional;

public interface AsientoService {
    List<Asiento> obtenerAsientosPorFuncionYEstado(Integer idFuncion, EstadoAsiento estado);
    Optional<Asiento> obtenerAsientoPorId(Integer id);
    void actualizarEstadoAsiento(Asiento asiento, EstadoAsiento nuevoEstado);
}
