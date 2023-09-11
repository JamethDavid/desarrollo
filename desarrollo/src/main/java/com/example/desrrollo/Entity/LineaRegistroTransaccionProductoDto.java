package com.example.desrrollo.Entity;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link LineaRegistroTransaccionProducto}
 */
@Value
public class LineaRegistroTransaccionProductoDto implements Serializable {
    double cantidad;
    BigDecimal valorBruto;
    double tarifaIva;
    int tarifaConsumo;
}