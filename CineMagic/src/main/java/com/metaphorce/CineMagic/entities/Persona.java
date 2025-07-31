package com.metaphorce.CineMagic.entities;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;
    private String nombre;
    private String correo;

    // Se llama a la clase Cuenta entidad que permitira generar cuentas a partir de Persona
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Cuenta", referencedColumnName = "id_Cuenta")
    private Cuenta cuenta;

    // Este constructor vacio es necesario para que funcione JPA
    public Persona() {
    }

    // Getters y setters
    public Integer getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
