package com.example.desrrollo.Repository;

import com.example.desrrollo.Api.InformeVentaLineaProductoDTO;
import com.example.desrrollo.Query.ProductoNombreDTO;
import com.example.desrrollo.Entity.LineaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RepositoryLineaProducto extends JpaRepository<LineaProducto ,Long>{
    @Query("""
    SELECT NEW com.example.desrrollo.Query.ProductoNombreDTO(lp.nombre)
    FROM linea_producto lp

""")
    List<ProductoNombreDTO> findAllByNombre();

    @Query("""
    SELECT NEW com.example.desrrollo.Api.InformeVentaLineaProductoDTO(l.idLineaProducto,l.nombre,p.nombre,lt.valorTotal,lt.cantidad,rt.consecutivoGravado)
    FROM linea_producto l,producto p,linea_registro_transaccion_producto lt, registro_transaccion rt
    WHERE l.idLineaProducto = p.lineaProducto.idLineaProducto
    AND lt.producto.idProducto = p.idProducto
    AND lt.fechaInsercion = :fechaInicio
    AND lt.fechaInsercion = :fechaFinal
    AND rt.consecutivoGravado = lt.registroTransaccion.consecutivoGravado
    and rt.anulada= 0
    order by p.nombre
""")
    List<InformeVentaLineaProductoDTO> findAllByLineaProductoAndFAndFecha(LocalDateTime fechaInicio , LocalDateTime fechaFinal);

}
