package com.metaphorce.CineMagic.enums;

public enum Sala {
    SALA_1("Sala 1"),
    SALA_2("Sala 2"),
    SALA_3("Sala 3");

    private final String label;

    Sala(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
