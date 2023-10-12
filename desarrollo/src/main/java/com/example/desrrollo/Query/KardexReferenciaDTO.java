package com.example.desrrollo.Query;

import com.example.desrrollo.Entity.Producto;

public class KardexReferenciaDTO {
    private String idProducto;
    private String nombre;
    public KardexReferenciaDTO() {
    }
    public KardexReferenciaDTO(String idProducto, String nombre) {
        this.idProducto = idProducto;
        this.nombre = nombre;
    }
    public String getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
