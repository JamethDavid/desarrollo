package com.example.desrrollo.Api;

public class ProductoNombreDTO {
    private String nombre;

    public ProductoNombreDTO() {
    }

    public ProductoNombreDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

