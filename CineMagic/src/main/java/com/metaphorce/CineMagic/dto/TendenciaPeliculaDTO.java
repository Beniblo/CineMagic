package com.metaphorce.CineMagic.dto;

public class TendenciaPeliculaDTO {
    private Integer idPelicula;
    private String titulo;
    private Long totalCompras;
    private Double promedioEstrellas;

    public TendenciaPeliculaDTO(Integer idPelicula, String titulo, Long totalCompras, Double promedioEstrellas) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.totalCompras = totalCompras;
        this.promedioEstrellas = promedioEstrellas;
    }

    // Getters y Setters
    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(Long totalCompras) {
        this.totalCompras = totalCompras;
    }

    public Double getPromedioEstrellas() {
        return promedioEstrellas;
    }

    public void setPromedioEstrellas(Double promedioEstrellas) {
        this.promedioEstrellas = promedioEstrellas;
    }
}
