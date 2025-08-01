package com.metaphorce.CineMagic.services.impl;
import com.metaphorce.CineMagic.entities.Compra;
import com.metaphorce.CineMagic.repositories.CompraRepository;
import com.metaphorce.CineMagic.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Override
    public Compra guardarCompra(Compra compra) {
        return compraRepository.save(compra);
    }
}

