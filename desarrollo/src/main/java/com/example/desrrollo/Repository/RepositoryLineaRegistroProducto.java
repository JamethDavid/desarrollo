package com.example.desrrollo.Repository;


import com.example.desrrollo.Api.LineaRegistroTransaccionProductoDTO;
import com.example.desrrollo.Entity.LineaRegistroTransaccionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface RepositoryLineaRegistroProducto extends JpaRepository<LineaRegistroTransaccionProducto,Long> {

    @Query(value = "select rt.fecha, t.id_transaccion,rt.descripcion , rt.consecutivo_gravado , pe.nombre, l.cantidad ,l.valor_bruto " +
            "from  linea_registro_transaccion_producto l, registro_transaccion rt , transaccion t , persona pe " +
            "where l.consecutivo_gravado=rt.consecutivo_gravado " +
            "and t.id_transaccion=rt.transaccion  " +
            "and rt.tercero=pe.id_persona order by " +
            "l.id_linea_registro_transaccion_producto;" ,nativeQuery = true)


    List<Object[]>findAllLineaRegistroTransaccion();

    @Query(value = "SELECT NEW com.example.dto.LineaRegistroTransaccionDTO(rt.fecha, t.idTransaccion, rt.descripcion, rt.consecutivoGravado, pe.nombre, l.cantidad, l.valorBruto) " +
            "FROM LineaRegistroTransaccionProducto l " +
            "INNER JOIN l.registroTransaccion rt " +
            "INNER JOIN rt.transaccion t " +
            "INNER JOIN rt.tercero pe " +
            "ORDER BY l.idLineaRegistroTransaccionProducto")
    List<LineaRegistroTransaccionProductoDTO> findAllLineaRegistro();
}




