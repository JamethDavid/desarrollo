package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "persona")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Persona {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_persona")
    private String idPersona;
    @Column(name = "nombre")
    private  String nombre;
    @Column(name = "tipo_persona")
    private String tipoPersona;
    @Column(name = "regimen")
    private String regimen;
    @Column(name = "rol")
    private String rol;
    @Column(name = "acumulado_ventas")
    private long acumuladoVentas;
    @Column(name = "acumulado_compras")
    private long acumuladoCompras;
    @Column(name = "desde")
    private String desde;
    @Column(name = "ubicacion")
    private int ubicacion;
    @Column(name = "vendedor")
    private String vendedor;
    @Column(name = "zona")
    private int zona;
    @Column(name = "retencion")
    private boolean retencion;
    @Column(name = "usuario_insercion")
    private String usuarioInsercion;
    @Column(name = "fecha_insercion")
    private String fechaInsercion;
    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;
    @Column(name = "fecha_modificacion")
    private String fechaModificacion;
    @Column(name = "imagen")
    private String imagen;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "persona",orphanRemoval = true)
    private List<RegistroTransaccion> registroTransaccion;

}
