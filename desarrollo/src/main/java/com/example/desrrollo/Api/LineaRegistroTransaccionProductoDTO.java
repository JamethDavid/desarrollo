package com.example.desrrollo.Api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LineaRegistroTransaccionProductoDTO(
        LocalDateTime fecha,
        Long idTransaccion,
        String descripcion,
        String consecutivoGravado,
        String nombre,
        Double cantidad,
        BigDecimal valorBruto

) {
}
