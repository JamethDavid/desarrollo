package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "persona")


public class Persona {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_persona")
    private String idPersona;
    @Column
    private  String nombre;

    public Persona(String idPersona, String nombre) {
        this.idPersona = idPersona;
        this.nombre = nombre;
    }

    public Persona() {

    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
