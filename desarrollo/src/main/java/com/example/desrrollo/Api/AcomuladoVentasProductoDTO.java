package com.example.desrrollo.Api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AcomuladoVentasProductoDTO {
    private String consecutivoGravado;
    private BigDecimal total;
    private LocalDateTime fecha;
    private int anulada;
    private String nombre;
    private BigDecimal cantidad;

    public AcomuladoVentasProductoDTO() {
    }
    public AcomuladoVentasProductoDTO(String consecutivoGravado, BigDecimal total, LocalDateTime fecha, int anulada, String nombre, BigDecimal cantidad) {
        this.consecutivoGravado = consecutivoGravado;
        this.total = total;
        this.fecha = fecha;
        this.anulada = anulada;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getConsecutivoGravado() {
        return consecutivoGravado;
    }

    public void setConsecutivoGravado(String consecutivoGravado) {
        this.consecutivoGravado = consecutivoGravado;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getAnulada() {
        return anulada;
    }

    public void setAnulada(int anulada) {
        this.anulada = anulada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }
}
