package com.example.desrrollo.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "empresa")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpresaC {
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

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getPoolEmpresa() {
        return poolEmpresa;
    }

    public void setPoolEmpresa(String poolEmpresa) {
        this.poolEmpresa = poolEmpresa;
    }

    public String getPoolEmpresaAlterna() {
        return poolEmpresaAlterna;
    }

    public void setPoolEmpresaAlterna(String poolEmpresaAlterna) {
        this.poolEmpresaAlterna = poolEmpresaAlterna;
    }

    public String getDirectorio() {
        return directorio;
    }

    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }

    public String getUsuarioInsercion() {
        return usuarioInsercion;
    }

    public void setUsuarioInsercion(String usuarioInsercion) {
        this.usuarioInsercion = usuarioInsercion;
    }

    public Timestamp getFechaInsercion() {
        return fechaInsercion;
    }

    public void setFechaInsercion(Timestamp fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getIpServidor() {
        return ipServidor;
    }

    public void setIpServidor(String ipServidor) {
        this.ipServidor = ipServidor;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }
}
