package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity(name = "registro_transaccion_dinero_inventario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Builder
public class RegistroTransaccionDineroInventario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "consecutivo_gravado")
    private String consecutivoGravado;
    private String descripcion;
    private int entrada;
    private  int caja;

    public void setConsecutivoGravado(String consecutivoGravado) {
        this.consecutivoGravado = consecutivoGravado;
    }

    public String getConsecutivoGravado() {

        return consecutivoGravado;
    }
}
