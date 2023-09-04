package com.example.desrrollo.Api;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Builder
public class ResponseLineaRegistroTransaccionProducto {

    private long idLineaRegistroTransaccionProducto;
    private double cantidad;
    private double valorBruto;
    private double tarifaIva;
    private int tarifaConsumo;
    private double valorTotal;
    private String transaccion;
    private String idRegistroTransaccion;
    private String idProducto;
    private String nombreProducto;
    private double valorUnitario;
    private float porcentajeIVA;
    private int porcentajeConsumo;
    private double descuento;
    private int ubica;
    private String usuarioInsercion;
    private String fechaInsercion;
    private String usuarioModificacion;
    private String fechaModificacion;
    private String asesor;
}
