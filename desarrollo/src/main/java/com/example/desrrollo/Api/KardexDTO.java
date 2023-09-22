package com.example.desrrollo.Api;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class KardexDTO {
    private Long idKardex;
    private LocalDateTime fecha;
    private String detalle;
    private BigDecimal valorUnitario;
    private BigDecimal cantidadEntrada;
    private BigDecimal valorEntrada;
    private BigDecimal valorSalida;
    private BigDecimal cantidadSaldo;
    private BigDecimal valorSaldo;
    private Integer ubica;
    private String documento;

    public KardexDTO() {
    }

    public KardexDTO(Long idKardex, LocalDateTime fecha,
                     String detalle, BigDecimal valorUnitario,
                     BigDecimal cantidadEntrada, BigDecimal valorEntrada,
                     BigDecimal valorSalida, BigDecimal cantidadSaldo,
                     BigDecimal valorSaldo, Integer ubica, String documento) {
        this.idKardex = idKardex;
        this.fecha = fecha;
        this.detalle = detalle;
        this.valorUnitario = valorUnitario;
        this.cantidadEntrada = cantidadEntrada;
        this.valorEntrada = valorEntrada;
        this.valorSalida = valorSalida;
        this.cantidadSaldo = cantidadSaldo;
        this.valorSaldo = valorSaldo;
        this.ubica = ubica;
        this.documento = documento;
    }

    public Long getIdKardex() {
        return idKardex;
    }

    public void setIdKardex(Long idKardex) {
        this.idKardex = idKardex;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getCantidadEntrada() {
        return cantidadEntrada;
    }

    public void setCantidadEntrada(BigDecimal cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    public BigDecimal getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(BigDecimal valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public BigDecimal getValorSalida() {
        return valorSalida;
    }

    public void setValorSalida(BigDecimal valorSalida) {
        this.valorSalida = valorSalida;
    }

    public BigDecimal getCantidadSaldo() {
        return cantidadSaldo;
    }

    public void setCantidadSaldo(BigDecimal cantidadSaldo) {
        this.cantidadSaldo = cantidadSaldo;
    }

    public BigDecimal getValorSaldo() {
        return valorSaldo;
    }

    public void setValorSaldo(BigDecimal valorSaldo) {
        this.valorSaldo = valorSaldo;
    }

    public Integer getUbica() {
        return ubica;
    }

    public void setUbica(Integer ubica) {
        this.ubica = ubica;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
