package com.metaphorce.CineMagic.enums;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum NumeroFila {
    UNO("1"),
    DOS("2"),
    TRES("3"),
    CUATRO("4"),
    CINCO("5"),
    SEIS("6"),
    SIETE("7"),
    OCHO("8"),
    NUEVE("9"),
    DIEZ("10"),
    ONCE("11"),
    DOCE("12"),
    TRECE("13"),
    CATORCE("14");

    private final String valor;

    NumeroFila(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @JsonCreator
    public static NumeroFila from(String valor) {
        for (NumeroFila numero : values()) {
            if (numero.valor.equals(valor)) {
                return numero;
            }
        }
        throw new IllegalArgumentException("Número de fila inválido: " + valor);
    }

    @Override
    public String toString() {
        return this.valor;
    }
}
