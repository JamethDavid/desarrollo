package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Long idTransaccion;

    @Column(name = "impuestos")
    private boolean impuestos;

    @Column(name = "consecutivo")
    private int consecutivo;

    @Column(name = "resolucion")
    private int resolucion;

    @Column(name = "usuario_insercion", length = 45)
    private String usuarioInsercion;

    @Column(name = "fecha_insercion")
    private LocalDateTime fechaInsercion;

    @Column(name = "usuario_modificacion", length = 45)
    private String usuarioModificacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "transaccion", orphanRemoval = true)
    private List<RegistroTransaccion> registroTransaccion;
}

