package com.metaphorce.CineMagic.services.impl;

import com.metaphorce.CineMagic.entities.Asiento;
import com.metaphorce.CineMagic.enums.EstadoAsiento;
import com.metaphorce.CineMagic.repositories.AsientoRepository;
import com.metaphorce.CineMagic.services.AsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsientoServiceImpl implements AsientoService {

    @Autowired
    private AsientoRepository asientoRepository;

    @Override
    public List<Asiento> obtenerAsientosPorFuncionYEstado(Integer idFuncion, EstadoAsiento estado) {
        return asientoRepository.findByFuncion_IdFuncionAndEstado(idFuncion, estado);
    }

    @Override
    public Optional<Asiento> obtenerAsientoPorId(Integer id) {
        return asientoRepository.findById(id);
    }

    @Override
    public void actualizarEstadoAsiento(Asiento asiento, EstadoAsiento nuevoEstado) {
        asiento.setEstado(nuevoEstado);
        asientoRepository.save(asiento);
    }
}
