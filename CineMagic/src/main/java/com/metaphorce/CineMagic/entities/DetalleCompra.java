package com.metaphorce.CineMagic.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DetalleCompra")
public class DetalleCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_DetalleCompra")
    private Integer idDetalleCompra;

    @ManyToOne
    @JoinColumn(name = "id_Compra", referencedColumnName = "id_Compra", nullable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_Asiento", referencedColumnName = "id_Asiento", nullable = false)
    private Asiento asiento;

    // Constructor vacío requerido por JPA
    public DetalleCompra() {
    }

    // Getters y Setters
    public Integer getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(Integer idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
}

