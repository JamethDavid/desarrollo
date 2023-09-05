package com.example.desrrollo.Api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LineaRegistroTransaccionProductoDTO(

        LocalDateTime fecha,
        String  transaccion,
        String descripcion,
        String consecutivoGravado,
        String nombre,
        Double cantidad,
        BigDecimal valorBruto




) {
}
