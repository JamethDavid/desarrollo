package com.example.desrrollo.Api;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;



public class LineaRegistroTransaccionProductoDTO {
    LocalDateTime fecha;
    Long  transaccion;
    String descripcion;
    String consecutivoGravado;
    String nombre;
    Double cantidad;
    BigDecimal valorBruto;

    public LineaRegistroTransaccionProductoDTO(LocalDateTime fecha, Long transaccion, String descripcion, String consecutivoGravado, String nombre, Double cantidad, BigDecimal valorBruto) {
        this.fecha = fecha;
        this.transaccion = transaccion;
        this.descripcion = descripcion;
        this.consecutivoGravado = consecutivoGravado;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.valorBruto = valorBruto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Long getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Long transaccion) {
        this.transaccion = transaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getConsecutivoGravado() {
        return consecutivoGravado;
    }

    public void setConsecutivoGravado(String consecutivoGravado) {
        this.consecutivoGravado = consecutivoGravado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }
}
