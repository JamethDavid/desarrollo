package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name ="linea_producto")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LineaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_linea_producto")
    private Long idLineaProducto;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "descripcion", length = 60)
    private String descripcion;

    @Column(name = "bien")
    private Boolean bien;

    @Column(name = "imagen", columnDefinition = "text")
    private String imagen;

    @Column(name = "costoventa", length = 20)
    private String costoVenta;

    @Column(name = "inventario", length = 20)
    private String inventario;

    @Column(name = "costoventatipo", length = 1)
    private String costoVentaTipo;

    @Column(name = "inventariotipo", length = 1)
    private String inventarioTipo;

    @Column(name = "ingreso", length = 20)
    private String ingreso;

    @Column(name = "tipoingreso", length = 1)
    private String tipoIngreso;

    @Column(name = "usuario_insercion", length = 45)
    private String usuarioInsercion;

    @Column(name = "fecha_insercion")
    private LocalDateTime fechaInsercion;

    @Column(name = "usuario_modificacion", length = 45)
    private String usuarioModificacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "lineaProducto", orphanRemoval = true)
    List<Producto>productos;
}
