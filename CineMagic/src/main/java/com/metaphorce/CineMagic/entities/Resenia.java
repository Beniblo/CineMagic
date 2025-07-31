package com.metaphorce.CineMagic.entities;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Resenia")
public class Resenia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Resenia")
    private Integer idResenia;

    @Column(nullable = false)
    private LocalDate fecha;

    @Lob
    @Column(nullable = false)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "id_Espectador", referencedColumnName = "idPersona", nullable = false)
    private Espectador espectador;

    // Este constructor vacio es necesario para que funcione JPA
    public Resenia() {
    }

    // Getters y Setters
    public Integer getIdResenia() {
        return idResenia;
    }

    public void setIdResenia(Integer idResenia) {
        this.idResenia = idResenia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }
}
