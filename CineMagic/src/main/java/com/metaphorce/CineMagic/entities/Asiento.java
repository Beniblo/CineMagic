package com.metaphorce.CineMagic.entities;
import com.metaphorce.CineMagic.converters.NumeroFilaConverter;
import com.metaphorce.CineMagic.enums.EstadoAsiento;
import com.metaphorce.CineMagic.enums.Fila;
import com.metaphorce.CineMagic.enums.NumeroFila;
import jakarta.persistence.*;

@Entity
@Table(name = "Asiento")
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Asiento")
    private Integer idAsiento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Fila fila;

    @Convert(converter = NumeroFilaConverter.class)
    @Column(nullable = false)
    private NumeroFila numeroFila;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoAsiento estado;

    @ManyToOne
    @JoinColumn(name = "id_Funcion", referencedColumnName = "id_Funcion", nullable = false)
    private Funcion funcion;

    // Este constructor vacio es necesario para que funcione JPA
    public Asiento() {
    }

    // Getters y setters
    public Integer getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public NumeroFila getNumeroFila() {
        return numeroFila;
    }

    public void setNumeroFila(NumeroFila numeroFila) {
        this.numeroFila = numeroFila;
    }

    public EstadoAsiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsiento estado) {
        this.estado = estado;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }
}
