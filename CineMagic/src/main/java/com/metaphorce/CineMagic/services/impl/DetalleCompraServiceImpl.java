package com.metaphorce.CineMagic.services.impl;
import com.metaphorce.CineMagic.entities.DetalleCompra;
import com.metaphorce.CineMagic.repositories.DetalleCompraRepository;
import com.metaphorce.CineMagic.services.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Override
    public void guardarDetalle(DetalleCompra detalle) {
        detalleCompraRepository.save(detalle);
    }
}
