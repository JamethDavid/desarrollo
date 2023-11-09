package com.example.desrrollo.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity(name = "empresa")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private int idEmpresa;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "nit")
    private String nit;

    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    @Column(name = "pool_empresa")
    private String poolEmpresa;

    @Column(name = "pool_empresa_alterna")
    private String poolEmpresaAlterna;

    @Column(name = "directorio")
    private String directorio;

    @Column(name = "usuario_insercion")
    private String usuarioInsercion;

    @Column(name = "fecha_insercion")
    private Timestamp fechaInsercion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;

    @Column(name = "fecha_modificacion")
    private Timestamp fechaModificacion;

    @Column(name = "ip_servidor")
    private String ipServidor;

    @Column(name = "rep_legal")
    private String representanteLegal;
}
