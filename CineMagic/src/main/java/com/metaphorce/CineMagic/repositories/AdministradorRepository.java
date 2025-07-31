package com.metaphorce.CineMagic.repositories;
import com.metaphorce.CineMagic.entities.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{

}
