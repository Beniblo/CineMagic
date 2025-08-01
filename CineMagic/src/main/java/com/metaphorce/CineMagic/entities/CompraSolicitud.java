package com.metaphorce.CineMagic.entities;

import java.math.BigDecimal;
import java.util.List;

public class CompraSolicitud {
    private Integer idEspectador;
    private List<Integer> idsAsientos;
    private String medioPago;
    private BigDecimal total;

    // Getters y Setters
    public Integer getIdEspectador() { return idEspectador; }
    public void setIdEspectador(Integer idEspectador) { this.idEspectador = idEspectador; }

    public List<Integer> getIdsAsientos() { return idsAsientos; }
    public void setIdsAsientos(List<Integer> idsAsientos) { this.idsAsientos = idsAsientos; }

    public String getMedioPago() { return medioPago; }
    public void setMedioPago(String medioPago) { this.medioPago = medioPago; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
