package com.example.desrrollo.Api;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RegistroTransaccionInformeEntradaInventarioDTO {
    private String consecutivoGravado;
    private LocalDateTime fecha;
    private BigDecimal total;
    public RegistroTransaccionInformeEntradaInventarioDTO() {
    }
    public RegistroTransaccionInformeEntradaInventarioDTO(String consecutivoGravado, LocalDateTime fecha, BigDecimal total) {
        this.consecutivoGravado = consecutivoGravado;
        this.fecha = fecha;
        this.total = total;
    }
    public String getConsecutivoGravado() {
        return consecutivoGravado;
    }
    public void setConsecutivoGravado(String consecutivoGravado) {
        this.consecutivoGravado = consecutivoGravado;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
