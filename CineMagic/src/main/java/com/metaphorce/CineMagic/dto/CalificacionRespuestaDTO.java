package com.metaphorce.CineMagic.dto;
import java.time.LocalDate;

public class CalificacionRespuestaDTO {
    private int estrellas;
    private LocalDate fecha;
    private String nombreEspectador;
    private String tituloPelicula;

    public CalificacionRespuestaDTO() {
    }

    public CalificacionRespuestaDTO(int estrellas, LocalDate fecha, String nombreEspectador, String tituloPelicula) {
        this.estrellas = estrellas;
        this.fecha = fecha;
        this.nombreEspectador = nombreEspectador;
        this.tituloPelicula = tituloPelicula;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombreEspectador() {
        return nombreEspectador;
    }

    public void setNombreEspectador(String nombreEspectador) {
        this.nombreEspectador = nombreEspectador;
    }

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }
}
