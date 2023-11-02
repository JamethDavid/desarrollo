package com.example.desrrollo.Query;

public class EmpresaDTO {
    private int idEmpresa;
    private String usuario;
    private String nit;
    private String nombreEmpresa;

    public EmpresaDTO(int idEmpresa, String usuario, String nit, String nombreEmpresa) {
        this.idEmpresa = idEmpresa;
        this.usuario = usuario;
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
    }

    public EmpresaDTO() {
    }

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
}
