package com.metaphorce.CineMagic.enums;

public enum Formato {
    _2D("2D"),
    _3D("3D"),
    IMAX("IMAX");

    private final String label;

    Formato(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
