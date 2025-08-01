package com.metaphorce.CineMagic.repositories;
import com.metaphorce.CineMagic.entities.Asiento;
import com.metaphorce.CineMagic.enums.EstadoAsiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento, Integer> {
    List<Asiento> findByFuncion_IdFuncionAndEstado(Integer idFuncion, EstadoAsiento estado);
}
