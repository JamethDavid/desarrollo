package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "registro_transaccion")
public class RegistroTransaccion{
    @Id
    @Column(nullable = false,name = "consecutivo_gravado", length = 24)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String consecutivoGravado;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fecha;
    @Column(nullable = false,name="descripcion")
    private String descripcion;
    @Column(nullable = false,name="anulada")
    private boolean anulada;
    @Column(nullable = false,name="subtotal")
    private double subtotal;
    @Column(nullable = false,name="total")
    private double total;
    @Column(nullable = false,name="impoconsumo")
    private double impoconsumo;
    @Column(nullable = false,name="tipo")
    private String tipo;
    @Column(name = "formaPago")
    private String formaPago;
    @Column(nullable = false,name="estado")
    private String estado;
    @Column(nullable = false,name="fecha_vencimiento")
    private LocalDateTime fechaVencimiento;
    //private String empresa;
    //@ManyToOne
    //@JoinColumn(name = "persona")
    //private Persona persona;
    //@ManyToOne
    //@JoinColumn(name = "transaccion")
    //private Transacion transaccion;
    //private String tercero;
    //@ManyToOne
    //@JoinColumn(name="impuesto_id_impuesto")
   // private Impuesto impuesto_id_impuesto;
    @Column(nullable = false,name="usuario_insercion")
    private String usuarioInsercion;
    @Column(nullable = false,name="usuario_modificacion")
    private String usuarioModificacion;
    @Column(nullable = false,name="fecha_modificacion")
    private LocalDateTime fechaModificacion;
    @Column(nullable = false,name="fecha_insercion")
    private LocalDateTime fechaInsercion;
    @Column(nullable = false,name="descuento1")
    private double desc1;
    @Column(nullable = false,name="descuento2")
    private double desc2;
    @Column(nullable = false,name="descuento3")
    private double desc3;
    @Column(nullable = false,name="descuento4")
    private double desc4;
    @Column(nullable = false,name="observacion")
    private String observacion;
    @Column(nullable = false,name="asociado")
    private String asociado;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "consecutivoGravado",orphanRemoval = true)
    private List<LineaRegistroTransaccionProducto> LineaRegistroTransaccionProducto;

    public RegistroTransaccion(String consecutivoGravado, LocalDateTime fecha, String descripcion, boolean anulada, double subtotal, double total, double impoconsumo, String tipo, String formaPago, String estado, LocalDateTime fechaVencimiento, String usuarioInsercion, String usuarioModificacion, LocalDateTime fechaModificacion, LocalDateTime fechaInsercion, double desc1, double desc2, double desc3, double desc4, String observacion, String asociado, List<com.example.desrrollo.Entity.LineaRegistroTransaccionProducto> lineaRegistroTransaccionProducto) {
        this.consecutivoGravado = consecutivoGravado;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.anulada = anulada;
        this.subtotal = subtotal;
        this.total = total;
        this.impoconsumo = impoconsumo;
        this.tipo = tipo;
        this.formaPago = formaPago;
        this.estado = estado;
        this.fechaVencimiento = fechaVencimiento;
        this.usuarioInsercion = usuarioInsercion;
        this.usuarioModificacion = usuarioModificacion;
        this.fechaModificacion = fechaModificacion;
        this.fechaInsercion = fechaInsercion;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.desc3 = desc3;
        this.desc4 = desc4;
        this.observacion = observacion;
        this.asociado = asociado;
        LineaRegistroTransaccionProducto = lineaRegistroTransaccionProducto;
    }

    public RegistroTransaccion() {

    }

    public String getConsecutivoGravado() {
        return consecutivoGravado;
    }

    public void setConsecutivoGravado(String consecutivoGravado) {
        this.consecutivoGravado = consecutivoGravado;
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

    public boolean isAnulada() {
        return anulada;
    }

    public void setAnulada(boolean anulada) {
        this.anulada = anulada;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getImpoconsumo() {
        return impoconsumo;
    }

    public void setImpoconsumo(double impoconsumo) {
        this.impoconsumo = impoconsumo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getUsuarioInsercion() {
        return usuarioInsercion;
    }

    public void setUsuarioInsercion(String usuarioInsercion) {
        this.usuarioInsercion = usuarioInsercion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public LocalDateTime getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(LocalDateTime fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }

    public double getDesc1() {
        return desc1;
    }

    public void setDesc1(double desc1) {
        this.desc1 = desc1;
    }

    public double getDesc2() {
        return desc2;
    }

    public void setDesc2(double desc2) {
        this.desc2 = desc2;
    }

    public double getDesc3() {
        return desc3;
    }

    public void setDesc3(double desc3) {
        this.desc3 = desc3;
    }

    public double getDesc4() {
        return desc4;
    }

    public void setDesc4(double desc4) {
        this.desc4 = desc4;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getAsociado() {
        return asociado;
    }

    public void setAsociado(String asociado) {
        this.asociado = asociado;
    }

    public List<com.example.desrrollo.Entity.LineaRegistroTransaccionProducto> getLineaRegistroTransaccionProducto() {
        return LineaRegistroTransaccionProducto;
    }

    public void setLineaRegistroTransaccionProducto(List<com.example.desrrollo.Entity.LineaRegistroTransaccionProducto> lineaRegistroTransaccionProducto) {
        LineaRegistroTransaccionProducto = lineaRegistroTransaccionProducto;
    }
}



