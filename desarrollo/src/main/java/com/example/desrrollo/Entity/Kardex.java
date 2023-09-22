package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity(name = "kardex")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Kardex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kardex")
    private Long idKardex;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "detalle", length = 250)
    private String detalle;

    @Column(name = "valor_unitario", precision = 20, scale = 2)
    private BigDecimal valorUnitario;

    @Column(name = "cantidad_entrada", precision = 20, scale = 2)
    private BigDecimal cantidadEntrada;

    @Column(name = "valor_entrada", precision = 20, scale = 2)
    private BigDecimal valorEntrada;

    @Column(name = "cantidad_salida", precision = 20, scale = 2)
    private BigDecimal cantidadSalida;

    @Column(name = "valor_salida", precision = 20, scale = 2)
    private BigDecimal valorSalida;

    @Column(name = "cantidad_saldo", precision = 20, scale = 2)
    private BigDecimal cantidadSaldo;

    @Column(name = "valor_saldo", precision = 20, scale = 2)
    private BigDecimal valorSaldo;

    @Column(name = "usuario_insercion", length = 45)
    private String usuarioInsercion;

    @Column(name = "fecha_insercion")
    private LocalDateTime fechaInsercion;

    @Column(name = "usuario_modificacion", length = 45)
    private String usuarioModificacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @ManyToOne()
    @JoinColumn(name = "producto")
    private Producto producto;

    @Column(name = "ubica")
    private Integer ubica;

    @Column(name = "documento", length = 45)
    private String documento;

    @Column(name = "costoante", precision = 20, scale = 2)
    private BigDecimal costoante;

}
