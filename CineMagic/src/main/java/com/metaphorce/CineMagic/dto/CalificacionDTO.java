package com.metaphorce.CineMagic.dto;

public class CalificacionDTO {
    private int estrellas;
    private Integer idPelicula;
    private Integer idEspectador;

    public CalificacionDTO() {
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Integer getIdEspectador() {
        return idEspectador;
    }

    public void setIdEspectador(Integer idEspectador) {
        this.idEspectador = idEspectador;
    }
}
