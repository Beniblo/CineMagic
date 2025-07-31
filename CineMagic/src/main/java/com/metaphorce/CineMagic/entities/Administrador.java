package com.metaphorce.CineMagic.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "Administrador")
@PrimaryKeyJoinColumn(name = "id_Persona")
public class Administrador extends Persona{

    // Este constructor vacio es necesario para que funcione JPA
    public Administrador() {
        super();
    }
}
