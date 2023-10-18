package com.example.desrrollo.Api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RegistroTransaccionInformeClienteDTO {
    private String consecutivoGravado;
    private String nombre;
    private LocalDateTime fecha;
    private String descripcion;
    private BigDecimal subtotal;
    private BigDecimal total;
    private LocalDateTime fechaVencimiento;


    public RegistroTransaccionInformeClienteDTO() {
    }

    public RegistroTransaccionInformeClienteDTO(String consecutivoGravado, String nombre,
                                                LocalDateTime fecha, String descripcion,
                                                BigDecimal subtotal, BigDecimal total,LocalDateTime fechaVencimiento) {
        this.consecutivoGravado = consecutivoGravado;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.subtotal = subtotal;
        this.total = total;
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}
