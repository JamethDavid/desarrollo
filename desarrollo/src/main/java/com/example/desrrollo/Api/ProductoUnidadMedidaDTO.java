package com.example.desrrollo.Api;

public class ProductoUnidadMedidaDTO {
    private String idProducto;
    private String nombre;
    private String nombreUnidad;
    public ProductoUnidadMedidaDTO() {
    }

    public ProductoUnidadMedidaDTO(String idProducto, String nombre, String nombreUnidad) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.nombreUnidad = nombreUnidad;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }
}

