package com.example.desrrollo.Api;

public class ProductoUnidadMedidaInventarioDTO extends ProductoUnidadMedidaDTO{
    private double existenciasReale;
    private long costo;



    public ProductoUnidadMedidaInventarioDTO() {
    }


    public ProductoUnidadMedidaInventarioDTO(String idProducto, String nombre, String nombreUnidad,double existenciasReale ,  long costo) {
        super(idProducto, nombre, nombreUnidad);
        this.existenciasReale = existenciasReale;
        this.costo = costo;

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
}
