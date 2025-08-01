package com.metaphorce.CineMagic.dto;

public class ReseniaDTO {
    private String contenido;
    private Integer idEspectador;
    private Integer idPelicula;

    public ReseniaDTO() {}

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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
