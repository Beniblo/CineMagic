package com.metaphorce.CineMagic.repositories;
import com.metaphorce.CineMagic.entities.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Integer> {

}
