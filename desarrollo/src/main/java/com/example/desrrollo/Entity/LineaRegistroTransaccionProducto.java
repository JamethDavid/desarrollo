package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "linea_registro_transaccion_producto")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LineaRegistroTransaccionProducto {
    @Id
    @Column(name = "id_linea_registro_transaccion_producto")
    private Long idLineaRegistroTransaccionProducto;

    @Column(name = "cantidad", precision = 20, scale = 2)
    private BigDecimal cantidad;

    @Column(name = "valor_bruto", precision = 20, scale = 2)
    private BigDecimal valorBruto;

    @Column(name = "tarifa_iva", precision = 20, scale = 2)
    private BigDecimal tarifaIva;

    @Column(name = "tarifa_consumo")
    private int tarifaConsumo;

    @Column(name = "valor_total", precision = 20, scale = 2)
    private BigDecimal valorTotal;

    @Column(name = "transaccion")
    private String transaccion;

    @ManyToOne
    @JoinColumn(name = "consecutivo_gravado")
    private RegistroTransaccion registroTransaccion;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @Column(name = "descuento", precision = 20, scale = 2)
    private BigDecimal descuento;

    @Column(name = "usuario_insercion")
    private String usuarioInsercion;

    @Column(name = "fecha_insercion")
    private LocalDateTime fechaInsercion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "asesor")
    private String asesor;

    @Column(name = "ubicacion")
    private int ubicacion;
}

