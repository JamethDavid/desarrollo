package com.example.desrrollo.Api;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Builder

public class LineaRegistroTransaccionProductoDTO {
    LocalDateTime fecha;
    Long  transaccion;
    String descripcion;
    String consecutivoGravado;
    String nombre;
    Double cantidad;
    BigDecimal valorBruto;
}
