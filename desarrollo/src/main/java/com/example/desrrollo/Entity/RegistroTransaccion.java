package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "registro_transaccion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Builder
public class RegistroTransaccion{
    @Id
    @Column(nullable = false,name = "consecutivo_gravado", length = 24)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String consecutivoGravado;
    @Column(nullable = false,name="fecha")
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

}



