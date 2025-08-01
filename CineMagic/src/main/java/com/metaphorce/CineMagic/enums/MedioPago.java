package com.metaphorce.CineMagic.enums;

public enum MedioPago {
    EFECTIVO,
    TARJETA,
    TRANSFERENCIA,
    PAYPAL;

    public static MedioPago from(String valor) {
        return MedioPago.valueOf(valor.trim().toUpperCase());
    }
}