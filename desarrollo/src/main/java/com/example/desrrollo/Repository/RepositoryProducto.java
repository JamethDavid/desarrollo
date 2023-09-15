package com.example.desrrollo.Repository;

import com.example.desrrollo.Api.ProductoUnidadMedidaDTO;
import com.example.desrrollo.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryProducto extends JpaRepository<Producto,String> {

    @Query("""
    SELECT NEW com.example.desrrollo.Api.ProductoUnidadMedidaDTO(p.idProducto,p.nombre,u.nombreUnidad,p.precioVenta1,p.precioVenta2,p.precioVenta3)
    FROM producto p
    JOIN p.unidadMedida u
""")
    List<ProductoUnidadMedidaDTO>findAllProductoUnidadMedidaDTO();


    @Query("""
    SELECT NEW com.example.desrrollo.Api.ProductoUnidadMedidaDTO(p.idProducto,p.nombre,u.nombreUnidad,p.existenciasReale,p.existenciasVirtuale)
    FROM producto p
    JOIN p.unidadMedida u
""")


    List<ProductoUnidadMedidaDTO>findAllProductoUnidadMedidaDTOListaExistente();

    @Query("""
    SELECT NEW com.example.desrrollo.Api.ProductoUnidadMedidaDTO(p.idProducto,p.nombre,u.nombreUnidad,p.existenciasReale,p.costo)
    FROM producto p
    JOIN p.unidadMedida u
""")
    List<ProductoUnidadMedidaDTO>findAllProductoUnidadMedidaDTOInentarioValorizado();
}
