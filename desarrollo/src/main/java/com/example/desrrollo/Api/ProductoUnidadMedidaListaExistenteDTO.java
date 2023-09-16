package com.example.desrrollo.Api;

public class ProductoUnidadMedidaListaExistenteDTO extends  ProductoUnidadMedidaDTO{
    private double existenciasReale;
    private double existenciasVirtuale;

    public ProductoUnidadMedidaListaExistenteDTO(String idProducto, String nombre, String nombreUnidad, double existenciasReale, double existenciasVirtuale) {
        super(idProducto, nombre, nombreUnidad);
        this.existenciasReale = existenciasReale;
        this.existenciasVirtuale = existenciasVirtuale;
    }
    public ProductoUnidadMedidaListaExistenteDTO() {
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
}
