package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "linea_registro_transaccion_producto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Builder
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
}
