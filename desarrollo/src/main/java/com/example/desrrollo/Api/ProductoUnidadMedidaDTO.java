package com.example.desrrollo.Api;

public class ProductoUnidadMedidaDTO {
    private String idProducto;
    private String nombre;
    private String nombreUnidad;
    private long precioVenta1;
    private long precioVenta2;
    private long precioVenta3;
    private double existenciasReale;
    private double existenciasVirtuale;
    private long costo;

    public ProductoUnidadMedidaDTO(String idProducto, String nombre, String nombreUnidad, double existenciasReale, long costo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.nombreUnidad = nombreUnidad;
        this.existenciasReale = existenciasReale;
        this.costo = costo;
    }


     public ProductoUnidadMedidaDTO(String idProducto, String nombre, String nombreUnidad, long precioVenta1, long precioVenta2, long precioVenta3) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.nombreUnidad = nombreUnidad;
        this.precioVenta1 = precioVenta1;
        this.precioVenta2 = precioVenta2;
        this.precioVenta3 = precioVenta3;

    }

    public ProductoUnidadMedidaDTO(String idProducto, String nombre, String nombreUnidad, double existenciasReale, double existenciasVirtuale) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.nombreUnidad = nombreUnidad;
        this.existenciasReale = existenciasReale;
        this.existenciasVirtuale = existenciasVirtuale;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }


    public double getExistenciasReale() {
        return existenciasReale;
    }

    public void setExistenciasReale(double existenciasReale) {
        this.existenciasReale = existenciasReale;
    }

    public double getExistenciasVirtuale() {
        return existenciasVirtuale;
    }

    public void setExistenciasVirtuale(double existenciasVirtuale) {
        this.existenciasVirtuale = existenciasVirtuale;
    }

    public ProductoUnidadMedidaDTO() {
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

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public long getPrecioVenta1() {
        return precioVenta1;
    }

    public void setPrecioVenta1(long precioVenta1) {
        this.precioVenta1 = precioVenta1;
    }

    public long getPrecioVenta2() {
        return precioVenta2;
    }

    public void setPrecioVenta2(long precioVenta2) {
        this.precioVenta2 = precioVenta2;
    }

    public long getPrecioVenta3() {
        return precioVenta3;
    }

    public void setPrecioVenta3(long precioVenta3) {
        this.precioVenta3 = precioVenta3;
    }
}

