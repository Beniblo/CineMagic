package com.metaphorce.CineMagic.enums;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Formato {
    _2D("2D"),
    _3D("3D"),
    IMAX("IMAX");

    private final String label;

    Formato(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static Formato fromValue(String value) {
        for (Formato f : Formato.values()) {
            if (f.label.equalsIgnoreCase(value)) {
                return f;
            }
        }
        throw new IllegalArgumentException("Formato desconocido: " + value);
    }
}


