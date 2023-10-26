package com.example.desrrollo.Api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReportePedidoPendienteDTO {
    private String consecutivoGravado;
    private String nombre;
    private LocalDateTime fecha;
    private BigDecimal subtotal;
    private BigDecimal total;
    private String observacion;

    public ReportePedidoPendienteDTO() {
    }

    public ReportePedidoPendienteDTO(String consecutivoGravado, String nombre, LocalDateTime fecha, BigDecimal subtotal, BigDecimal total, String observacion) {
        this.consecutivoGravado = consecutivoGravado;
        this.nombre = nombre;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = total;
        this.observacion = observacion;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
