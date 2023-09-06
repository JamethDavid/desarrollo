package com.example.desrrollo.projection;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface LineaRegistroTransaccionProductoProjections {
    LocalDateTime getFecha();
    Long  getTransaccion();
    String getDescripcion();
    String getConsecutivoGravado();
    String getNombre();
    Double getCantidad();
    BigDecimal getValorBruto();
}
