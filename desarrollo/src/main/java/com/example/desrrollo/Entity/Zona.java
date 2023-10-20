package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Zona")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Builder
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona")
    private int idZona;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "descripcion", length = 60)
    private String descripcion;

    @Column(name = "periodo_liquidacion")
    private int periodoLiquidacion;

    @Column(name = "usuario_insercion", length = 45)
    private String usuarioInsercion;

    @Column(name = "fecha_insercion")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaInsercion;

    @Column(name = "usuario_modificacion", length = 45)
    private String usuarioModificacion;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaModificacion;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "zona", orphanRemoval = true)
    private List<Persona> personas;
}
