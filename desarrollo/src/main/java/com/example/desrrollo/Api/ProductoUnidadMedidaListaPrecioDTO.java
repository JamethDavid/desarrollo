package com.example.desrrollo.Api;

public class ProductoUnidadMedidaListaPrecioDTO extends ProductoUnidadMedidaDTO{
    private long precioVenta1;
    private long precioVenta2;
    private long precioVenta3;

    public ProductoUnidadMedidaListaPrecioDTO(String idProducto, String nombre, String nombreUnidad, long precioVenta1, long precioVenta2, long precioVenta3) {
        super(idProducto, nombre, nombreUnidad);
        this.precioVenta1 = precioVenta1;
        this.precioVenta2 = precioVenta2;
        this.precioVenta3 = precioVenta3;
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
