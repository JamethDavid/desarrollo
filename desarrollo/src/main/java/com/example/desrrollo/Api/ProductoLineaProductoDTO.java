package com.example.desrrollo.Api;

public class ProductoLineaProductoDTO {
    private Long idLineaProducto;
    private String nombre;
    private String nombreProducto;
    private double existenciasReale;
    private long costo;
    private String idProducto;

    public ProductoLineaProductoDTO() {
    }

    public ProductoLineaProductoDTO(Long idLineaProducto, String nombre, String nombreProducto, double existenciasReale, long costo, String idProducto) {
        this.idLineaProducto = idLineaProducto;
        this.nombre = nombre;
        this.nombreProducto = nombreProducto;
        this.existenciasReale = existenciasReale;
        this.costo = costo;
        this.idProducto = idProducto;
    }

    public Long getIdLineaProducto() {
        return idLineaProducto;
    }

    public void setIdLineaProducto(Long idLineaProducto) {
        this.idLineaProducto = idLineaProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getExistenciasReale() {
        return existenciasReale;
    }

    public void setExistenciasReale(double existenciasReale) {
        this.existenciasReale = existenciasReale;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
}
