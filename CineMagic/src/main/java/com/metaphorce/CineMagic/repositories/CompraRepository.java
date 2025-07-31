package com.metaphorce.CineMagic.repositories;
import com.metaphorce.CineMagic.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

}
