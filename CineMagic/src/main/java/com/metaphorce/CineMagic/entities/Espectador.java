package com.metaphorce.CineMagic.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "Espectador")
public class Espectador extends Persona{

    // Este constructor vacio es necesario para que funcione JPA
    public Espectador() {
        super();
    }
}
