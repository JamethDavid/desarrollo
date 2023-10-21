package com.example.desrrollo.Api;

import java.math.BigDecimal;

public class ZonaReporteVentaDTO {
    private String nombre;
    private String descripcion;
    private String consecutivoGravado;
    private String tercero;
    private String personaNombre;
    private BigDecimal total;

    public ZonaReporteVentaDTO(String nombre, String descripcion, String consecutivoGravado, String tercero, String personaNombre, BigDecimal total) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.consecutivoGravado = consecutivoGravado;
        this.tercero = tercero;
        this.personaNombre = personaNombre;
        this.total = total;
    }

    public ZonaReporteVentaDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getTercero() {
        return tercero;
    }

    public void setTercero(String tercero) {
        this.tercero = tercero;
    }

    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
