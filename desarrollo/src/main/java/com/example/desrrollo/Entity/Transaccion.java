package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "transaccion")

public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Long idTransaccion;

    public Transaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Transaccion() {

    }

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
}
