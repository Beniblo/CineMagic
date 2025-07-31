package com.metaphorce.CineMagic.repositories;
import com.metaphorce.CineMagic.entities.Espectador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspectadorRepository extends JpaRepository<Espectador, Integer> {

}
