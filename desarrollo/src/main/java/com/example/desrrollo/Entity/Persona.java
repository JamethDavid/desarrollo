package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "persona")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Persona {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_persona", length = 15)
    private String idPersona;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "tipo_persona", length = 4)
    private String tipoPersona;

    @Column(name = "regimen", length = 4)
    private String regimen;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Rol rol;

    @Column(name = "acumulado_ventas", precision = 20, scale = 2)
    private BigDecimal acumuladoVentas;

    @Column(name = "acumulado_compras", precision = 20, scale = 2)
    private BigDecimal acumuladoCompras;

    @Column(name = "desde")
    private LocalDateTime desde;

    @Column(name = "ubicacion")
    private int ubicacion;

    @Column(name = "vendedor", length = 15)
    private String vendedor;

    @Column(name = "zona")
    private int zona;

    @Column(name = "retencion")
    private boolean retencion;

    @Column(name = "usuario_insercion", length = 45)
    private String usuarioInsercion;

    @Column(name = "fecha_insercion")
    private LocalDateTime fechaInsercion;

    @Column(name = "usuario_modificacion", length = 45)
    private String usuarioModificacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "imagen", length = 45)
    private String imagen;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "persona", orphanRemoval = true)
    private List<RegistroTransaccion> registroTransaccion;


    public enum Rol {
        Empleado, Cliente, Proveedor, Responsable, Otro
    }
}

