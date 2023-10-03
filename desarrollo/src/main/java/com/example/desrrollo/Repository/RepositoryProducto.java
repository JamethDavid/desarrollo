package com.example.desrrollo.Repository;

import com.example.desrrollo.Api.*;
import com.example.desrrollo.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepositoryProducto extends JpaRepository<Producto,String> {
    @Query("""
    SELECT NEW com.example.desrrollo.Api.ProductoUnidadMedidaListaPrecioDTO(p.idProducto,p.nombre,u.nombreUnidad,p.precioVenta1,p.precioVenta2,p.precioVenta3)
    FROM producto p
    JOIN p.unidadMedida u ON u.idUnidadMedida = p.unidadMedida.idUnidadMedida ORDER BY p.nombre ASC
""")
    List<ProductoUnidadMedidaListaPrecioDTO>findAllProductoUnidadMedidaListaPrecioDTO();
    @Query("""
    SELECT NEW com.example.desrrollo.Api.ProductoUnidadMedidaListaExistenteDTO(p.idProducto,p.nombre,u.nombreUnidad,p.existenciasReale,p.existenciasVirtuale)
    FROM producto p
    JOIN p.unidadMedida u ORDER BY p.nombre ASC
""")
    List<ProductoUnidadMedidaListaExistenteDTO>findAllProductoUnidadMedidaListaExistenteDTO();
    @Query("""
    SELECT NEW com.example.desrrollo.Api.ProductoUnidadMedidaInventarioDTO(p.idProducto,p.nombre,u.nombreUnidad,p.existenciasReale,p.costo)
    FROM producto p
    JOIN p.unidadMedida u where u.idUnidadMedida =p.unidadMedida.idUnidadMedida
    and p.existenciasReale>0
    ORDER BY p.nombre
    
""")
    List<ProductoUnidadMedidaInventarioDTO>findAllProductoUnidadMedidaInventarioValorizadoDTO();
    @Query("""
    SELECT NEW com.example.desrrollo.Api.KardexDTO(k.idKardex,k.fecha,k.detalle,k.valorUnitario,
    k.cantidadEntrada,k.valorEntrada,k.valorSaldo,
    k.cantidadSaldo,k.valorSaldo,k.ubica,k.documento)
    FROM kardex k where k.producto.idProducto =:idVendedor
""")
    List<KardexDTO>findAllByIdKardex(String idVendedor);

    @Query("""
    SELECT NEW com.example.desrrollo.Api.ProductoLineaProductoDTO(lp.idLineaProducto,lp.nombre,p.nombre,p.existenciasReale,p.costo,p.idProducto)
    FROM producto p
    JOIN p.lineaProducto lp
    where lp.nombre = :nombre
    order by p.nombre
""")
    List<ProductoLineaProductoDTO>findAllByNombre(String nombre);


}



