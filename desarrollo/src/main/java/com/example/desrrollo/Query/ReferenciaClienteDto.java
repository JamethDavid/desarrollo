package com.example.desrrollo.Query;

public class ReferenciaClienteDto {
    private String idPersona;
    private String nombre;
    public ReferenciaClienteDto() {
    }
    public ReferenciaClienteDto(String idPersona, String nombre) {
        this.idPersona = idPersona;
        this.nombre = nombre;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
