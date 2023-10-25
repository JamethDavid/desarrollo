package com.example.desrrollo.Api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ZonaReporteVentaFechaDTO {
    private String nombreZona;
    private String descripcion;
    private String nombreProducto;
    private BigDecimal total;
    private LocalDateTime fecha;
    private String consecutivoGravado;

    public ZonaReporteVentaFechaDTO() {
    }

    public ZonaReporteVentaFechaDTO(String nombreZona, String descripcion, String nombreProducto, BigDecimal total, LocalDateTime fecha, String consecutivoGravado) {
        this.nombreZona = nombreZona;
        this.descripcion = descripcion;
        this.nombreProducto = nombreProducto;
        this.total = total;
        this.fecha = fecha;
        this.consecutivoGravado = consecutivoGravado;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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

    public String getConsecutivoGravado() {
        return consecutivoGravado;
    }

    public void setConsecutivoGravado(String consecutivoGravado) {
        this.consecutivoGravado = consecutivoGravado;
    }
}
