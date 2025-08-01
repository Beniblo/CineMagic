package com.metaphorce.CineMagic.dto;

public class AsientoResumen {
    private String fila;
    private String numeroFila;
    private String estado;

    public AsientoResumen(String fila, String numeroFila, String estado) {
        this.fila = fila;
        this.numeroFila = numeroFila;
        this.estado = estado;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getNumeroFila() {
        return numeroFila;
    }

    public void setNumeroFila(String numeroFila) {
        this.numeroFila = numeroFila;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}