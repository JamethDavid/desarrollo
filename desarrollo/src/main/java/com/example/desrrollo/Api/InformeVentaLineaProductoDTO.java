package com.example.desrrollo.Api;

import java.math.BigDecimal;

public class InformeVentaLineaProductoDTO {
    private Long idLineaProducto;
    private String lineaProducto;
    private String nombreProducto;
    private BigDecimal valorTotal;
    private BigDecimal cantidad;
    private String consecutivoGravado;

    public InformeVentaLineaProductoDTO() {
    }

    public InformeVentaLineaProductoDTO(Long idLineaProducto, String lineaProducto, String nombreProducto, BigDecimal valorTotal, BigDecimal cantidad, String consecutivoGravado) {
        this.idLineaProducto = idLineaProducto;
        this.lineaProducto = lineaProducto;
        this.nombreProducto = nombreProducto;
        this.valorTotal = valorTotal;
        this.cantidad = cantidad;
        this.consecutivoGravado = consecutivoGravado;
    }

    public Long getIdLineaProducto() {
        return idLineaProducto;
    }

    public void setIdLineaProducto(Long idLineaProducto) {
        this.idLineaProducto = idLineaProducto;
    }

    public String getLineaProducto() {
        return lineaProducto;
    }

    public void setLineaProducto(String lineaProducto) {
        this.lineaProducto = lineaProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getConsecutivoGravado() {
        return consecutivoGravado;
    }

    public void setConsecutivoGravado(String consecutivoGravado) {
        this.consecutivoGravado = consecutivoGravado;
    }
}
