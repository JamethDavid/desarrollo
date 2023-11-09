package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empresa")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Empresa {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "rut")
    private String rut;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo_empresa")
    private String tipoEmpresa;

    @Column(name = "regimen")
    private String regimen;

    @Column(name = "url_logo")
    private String urlLogo;

    @Column(name = "ubicacion")
    private int ubicacion;

    @Column(name = "porcentaje_retencion_ica")
    private String porcentaje_retencion_ica;

    @Column(name = "representanteLegal")
    private String representanteLegal;

    @Column(name = "usuario_insercion")
    private String usuarioInsercion;

    @Column(name = "fecha_insercion")
    private String fechaInsercion;

    @Column(name = "usuario_modificacion")
    private String usuarioModificacion;

    @Column(name = "fecha_modificacion")
    private String fechaModificacion;

    @Column(name = "porcentaje_cree")
    private String porcentaje_cree;

    @Column(name = "api_token")
    private String apiToken;
}
