package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "registro_transaccion")
public class RegistroTransaccion {
    @Id
    @Column(nullable = false, name = "consecutivo_gravado", length = 24)
    private String consecutivoGravado;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false, name = "descripcion", length = 45)
    private String descripcion;

    @Column(nullable = false)
    private int anulada;

    @Column(nullable = false, precision = 20, scale = 2)
    private BigDecimal subtotal;

    @Column(nullable = false, precision = 20, scale = 2)
    private BigDecimal total;

    @Column(nullable = false, precision = 20, scale = 2)
    private BigDecimal impoconsumo;

    @Column(nullable = false, length = 4)
    private String tipo;

    @Column(name = "forma_pago", length = 2)
    private String formaPago;

    @Column(nullable = false, length = 4)
    private String estado;

    @Column(nullable = false)
    private LocalDateTime fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "persona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "transaccion")
    private Transaccion transaccion;

    @Column(name = "tercero", length = 15)
    private String tercero;

    @Column(nullable = false, name = "usuario_insercion", length = 45)
    private String usuarioInsercion;

    @Column(nullable = false, name = "usuario_modificacion", length = 45)
    private String usuarioModificacion;

    @Column(nullable = false, name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(nullable = false, name = "fecha_insercion")
    private LocalDateTime fechaInsercion;

    @Column(nullable = false, name = "descuento1", precision = 20, scale = 2)
    private BigDecimal desc1;

    @Column(nullable = false, name = "descuento2", precision = 20, scale = 2)
    private BigDecimal desc2;

    @Column(nullable = false, name = "descuento3", precision = 20, scale = 2)
    private BigDecimal desc3;

    @Column(nullable = false, name = "descuento4", precision = 20, scale = 2)
    private BigDecimal desc4;

    @Column(nullable = false, name = "observacion", length = 500)
    private String observacion;

    @Column(nullable = false, name = "asociado", length = 60)
    private String asociado;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "registroTransaccion", orphanRemoval = true)
    private List<LineaRegistroTransaccionProducto> lineaRegistroTransaccionProducto;
}




