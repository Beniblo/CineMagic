    package com.metaphorce.CineMagic.entities;
    import com.fasterxml.jackson.annotation.JsonBackReference;
    import com.fasterxml.jackson.annotation.JsonIgnore;
    import com.metaphorce.CineMagic.converters.FormatoConverter;
    import com.metaphorce.CineMagic.enums.Formato;
    import com.metaphorce.CineMagic.enums.Sala;
    import com.metaphorce.CineMagic.enums.SalaConverter;
    import jakarta.persistence.*;
    import java.time.LocalDate;
    import java.time.LocalTime;

    @Entity
    @Table(name = "Funcion")
    public class Funcion {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_Funcion")
        private Integer idFuncion;

        @Column(nullable = false)
        private LocalDate fecha;

        @Column(nullable = false)
        private LocalTime hora;

        @Convert(converter = SalaConverter.class)
        @Column(nullable = false)
        private Sala sala;

        @Convert(converter = FormatoConverter.class)
        @Column(nullable = false)
        private Formato formato;

        @ManyToOne
        @JoinColumn(name = "id_Pelicula")
        @JsonBackReference
        private Pelicula pelicula;

        @ManyToOne
        @JoinColumn(name = "id_Administrador", referencedColumnName = "id_Persona", nullable = false)
        @JsonIgnore
        private Administrador administrador;

        // Este constructor vacio es necesario para que funcione JPA
        public Funcion() {
        }

        // Getters y setters
        public Integer getIdFuncion() {
            return idFuncion;
        }

        public void setIdFuncion(Integer idFuncion) {
            this.idFuncion = idFuncion;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public LocalTime getHora() {
            return hora;
        }

        public void setHora(LocalTime hora) {
            this.hora = hora;
        }

        public Sala getSala() {
            return sala;
        }

        public void setSala(Sala sala) {
            this.sala = sala;
        }

        public Formato getFormato() {
            return formato;
        }

        public void setFormato(Formato formato) {
            this.formato = formato;
        }

        public Pelicula getPelicula() {
            return pelicula;
        }

        public void setPelicula(Pelicula pelicula) {
            this.pelicula = pelicula;
        }

        public Administrador getAdministrador() {
            return administrador;
        }

        public void setAdministrador(Administrador administrador) {
            this.administrador = administrador;
        }
    }

