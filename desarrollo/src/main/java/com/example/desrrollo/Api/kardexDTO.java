package com.example.desrrollo.Api;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class kardexDTO {
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

    public kardexDTO() {
    }

    public kardexDTO(Long idKardex, LocalDateTime fecha,
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
}
