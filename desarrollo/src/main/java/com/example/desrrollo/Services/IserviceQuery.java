package com.example.desrrollo.Services;

import com.example.desrrollo.Api.ProductoNombreDTO;
import com.example.desrrollo.Entity.Producto;

import java.util.List;

public interface IserviceQuery {
    List<ProductoNombreDTO>findAllByName();

}
