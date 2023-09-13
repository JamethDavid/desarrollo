package com.example.desrrollo.Api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LineaRegistroTransaccionProductoDTO {
        private LocalDateTime fecha;
        private Long idTransaccion;
        private String descripcion;
        private String consecutivoGravado;
        private String nombre;
        private BigDecimal cantidad;
        private BigDecimal valorBruto;
        public LineaRegistroTransaccionProductoDTO(LocalDateTime fecha, Long idTransaccion, String descripcion, String consecutivoGravado, String nombre, BigDecimal cantidad, BigDecimal valorBruto) {
                this.fecha = fecha;
                this.idTransaccion = idTransaccion;
                this.descripcion = descripcion;
                this.consecutivoGravado = consecutivoGravado;
                this.nombre = nombre;
                this.cantidad = cantidad;
                this.valorBruto = valorBruto;
        }

        public LocalDateTime getFecha() {
                return fecha;
        }

        public void setFecha(LocalDateTime fecha) {
                this.fecha = fecha;
        }

        public Long getIdTransaccion() {
                return idTransaccion;
        }

        public void setIdTransaccion(Long idTransaccion) {
                this.idTransaccion = idTransaccion;
        }

        public String getDescripcion() {
                return descripcion;
        }

        public void setDescripcion(String descripcion) {
                this.descripcion = descripcion;
        }

        public String getConsecutivoGravado() {
                return consecutivoGravado;
        }

        public void setConsecutivoGravado(String consecutivoGravado) {
                this.consecutivoGravado = consecutivoGravado;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public BigDecimal getCantidad() {
                return cantidad;
        }

        public void setCantidad(BigDecimal cantidad) {
                this.cantidad = cantidad;
        }

        public BigDecimal getValorBruto() {
                return valorBruto;
        }

        public void setValorBruto(BigDecimal valorBruto) {
                this.valorBruto = valorBruto;
        }
}

