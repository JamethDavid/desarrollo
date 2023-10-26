package com.example.desrrollo.Repository;


import com.example.desrrollo.Api.AcomuladoVentasProductoDTO;
import com.example.desrrollo.Api.LineaRegistroTransaccionProductoDTO;
import com.example.desrrollo.Entity.LineaRegistroTransaccionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RepositoryLineaRegistroProducto extends JpaRepository<LineaRegistroTransaccionProducto,Long> {

    @Query("""
    SELECT NEW com.example.desrrollo.Api.LineaRegistroTransaccionProductoDTO(r.fecha,t.idTransaccion,r.descripcion,r.consecutivoGravado,p.nombre,lrp.cantidad,lrp.valorBruto)
    FROM registro_transaccion r
    JOIN r.transaccion t
    JOIN r.persona p
    JOIN r.lineaRegistroTransaccionProducto lrp
""")
    List<LineaRegistroTransaccionProductoDTO>findAllByDTO();

    @Query("""
    SELECT NEW com.example.desrrollo.Api.AcomuladoVentasProductoDTO(rt.consecutivoGravado,rt.total,rt.fecha,rt.anulada,p.nombre,lr.cantidad)
    FROM producto p, linea_registro_transaccion_producto lr,registro_transaccion rt
    where  rt.consecutivoGravado = lr.registroTransaccion.consecutivoGravado
    and p.idProducto = lr.producto.idProducto
    and p.idProducto = :idProducto
    and rt.consecutivoGravado LIKE 'V%'
    and rt.anulada != 1
    and rt.fecha >= :fechaInicio
    and rt.fecha <= :fechaFinal
    ORDER BY
    rt.fecha ASC
  
""")
    List<AcomuladoVentasProductoDTO>findAllByAcomuladoVentaProducto(LocalDateTime fechaInicio,LocalDateTime fechaFinal,String idProducto);
}




