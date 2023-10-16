package com.example.desrrollo.Api;

import com.example.desrrollo.Entity.Producto;

import java.math.BigDecimal;

public class ProductoRentabilidadDTO {
    private String producto;
    private BigDecimal cantidadSalida;
    private BigDecimal valorSalida;
    private String nombre;
    private long costo;

    public ProductoRentabilidadDTO() {
    }

    public ProductoRentabilidadDTO(String producto, BigDecimal cantidadSalida, BigDecimal valorSalida, String nombre, long costo) {
        this.producto = producto;
        this.cantidadSalida = cantidadSalida;
        this.valorSalida = valorSalida;
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public BigDecimal getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(BigDecimal cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public BigDecimal getValorSalida() {
        return valorSalida;
    }

    public void setValorSalida(BigDecimal valorSalida) {
        this.valorSalida = valorSalida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }
}
