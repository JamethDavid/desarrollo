package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "linea_registro_transaccion_producto")
public class LineaRegistroTransaccionProducto {
    @Id
    @Column(name = "id_linea_registro_transaccion_producto")
    private Long idLineaRegistroTransaccionProducto;
    @Column(name = "cantidad")
    private double cantidad;
    @Column(name = "valor_bruto")
    private BigDecimal valorBruto;
    @Column(name = "tarifa_iva")
    private double tarifaIva;
    @Column(name = "tarifa_consumo")
    private int tarifaConsumo;
    @Column(name = "valor_total")
    private double valorTotal;
    @Column(name = "transaccion")
    private String transaccion;
    @ManyToOne
    @JoinColumn(name = "consecutivo_gravado")
    private RegistroTransaccion consecutivoGravado;
   // @ManyToOne
   //@JoinColumn( name = "id_producto")
   // private Producto idProducto;
    @Column(name = "descuento")
    private double descuento;
    @Column(name = "usuario_insercion")
    private String usuarioInsercion;
    @Column(name = "fecha_insercion")
    private String fechaInsercion;
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion")
    private String fechaModificacion;
    @Column(name = "asesor")
    private String asesor;
    @Column(name = "ubicacion")
    private  int ubicacion;

    public LineaRegistroTransaccionProducto(Long idLineaRegistroTransaccionProducto, double cantidad, BigDecimal valorBruto, double tarifaIva, int tarifaConsumo, double valorTotal, String transaccion, RegistroTransaccion consecutivoGravado, double descuento, String usuarioInsercion, String fechaInsercion, String usuarioModificacion, String fechaModificacion, String asesor, int ubicacion) {
        this.idLineaRegistroTransaccionProducto = idLineaRegistroTransaccionProducto;
        this.cantidad = cantidad;
        this.valorBruto = valorBruto;
        this.tarifaIva = tarifaIva;
        this.tarifaConsumo = tarifaConsumo;
        this.valorTotal = valorTotal;
        this.transaccion = transaccion;
        this.consecutivoGravado = consecutivoGravado;
        this.descuento = descuento;
        this.usuarioInsercion = usuarioInsercion;
        this.fechaInsercion = fechaInsercion;
        this.usuarioModificacion = usuarioModificacion;
        this.fechaModificacion = fechaModificacion;
        this.asesor = asesor;
        this.ubicacion = ubicacion;
    }

    public LineaRegistroTransaccionProducto() {

    }

    public Long getIdLineaRegistroTransaccionProducto() {
        return idLineaRegistroTransaccionProducto;
    }

    public void setIdLineaRegistroTransaccionProducto(Long idLineaRegistroTransaccionProducto) {
        this.idLineaRegistroTransaccionProducto = idLineaRegistroTransaccionProducto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(BigDecimal valorBruto) {
        this.valorBruto = valorBruto;
    }

    public double getTarifaIva() {
        return tarifaIva;
    }

    public void setTarifaIva(double tarifaIva) {
        this.tarifaIva = tarifaIva;
    }

    public int getTarifaConsumo() {
        return tarifaConsumo;
    }

    public void setTarifaConsumo(int tarifaConsumo) {
        this.tarifaConsumo = tarifaConsumo;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(String transaccion) {
        this.transaccion = transaccion;
    }

    public RegistroTransaccion getConsecutivoGravado() {
        return consecutivoGravado;
    }

    public void setConsecutivoGravado(RegistroTransaccion consecutivoGravado) {
        this.consecutivoGravado = consecutivoGravado;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getUsuarioInsercion() {
        return usuarioInsercion;
    }

    public void setUsuarioInsercion(String usuarioInsercion) {
        this.usuarioInsercion = usuarioInsercion;
    }

    public String getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(String fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }
}
