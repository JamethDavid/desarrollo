package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "producto")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Producto {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_producto")
    private String idProducto;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "costo")
    private long costo;
    @Column(name = "precio_venta1")
    private long precioVenta1;
    @Column(name = "precio_venta2")
    private long precioVenta2;
    @Column(name = "precio_venta3")
    private long precioVenta3;
    @Column(name = "porcentaje_iva")
    private float porcentajeIva;
    @Column(name = "porcentaje_consumo")
    private int porcentajeConsumo;
    @Column(name = "existencias_reales")
    private double existenciasReale;
    @Column(name = "stock")
    private int stock;
    @Column(name = "existencias_virtuales")
    private double existenciasVirtuale;
    @Column(name = "compuesto")
    private boolean compuesto;
    @Column(name = "facturacion_negativa")
    private boolean facturacionNegativa;
    @ManyToOne
    @JoinColumn(name = "unidad_medida")
    private UnidadMedida unidadMedida;
    @ManyToOne
    @JoinColumn(name = "linea_producto")
    private LineaProducto lineaProducto;
    @Column(name = "asesor")
    private String asesor;
    @Column(name = "usuario_insercion")
    private String usuarioInsercion;
    @Column(name = "fecha_insercion")
    private String fechaInsercion;
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion")
    private String fechaModificacion;
    @Column(name = "ensamblado")
    private boolean ensamblado;
    @Column(name = "foto")
    private String foto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "verpedidoweb")
    private int verpedidoweb;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true ,mappedBy = "producto")
    private List<LineaRegistroTransaccionProducto> LineaRegistroTransaccionProductos;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true,mappedBy = "producto")
    private List<Kardex> kardexes;
}
