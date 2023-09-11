package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "transaccion")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Long idTransaccion;
    @Column(name = "impuestos")
    private boolean impuestos;
    @Column(name = "formato")
    private String formato;
    @Column(name = "precio_sugerido")
    private String precioSugerido;
    @Column(name = "consecutivo")
    private int consecutivo;
    @Column(name = "resolucion")
    private int resolucion;
    @Column(name = "usuario_insercion")
    private String usuarioInsercion;
    @Column(name = "fecha_insercion")
    private String fechaInsercion;
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion")
    private String fechaModificacion;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "transaccion",orphanRemoval = true)
    private List<RegistroTransaccion> registroTransaccion;


}
