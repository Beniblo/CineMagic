package com.metaphorce.CineMagic.repositories;
import com.metaphorce.CineMagic.entities.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Integer> {
    List<Funcion> findByPelicula_IdPelicula(Integer idPelicula);
    List<Funcion> findByPelicula_Titulo(String tituloPelicula);
}
