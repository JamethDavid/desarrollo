package com.example.desrrollo.Repository;


import com.example.desrrollo.Api.LineaRegistroTransaccionProductoDTO;
import com.example.desrrollo.Entity.LineaRegistroTransaccionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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

}




