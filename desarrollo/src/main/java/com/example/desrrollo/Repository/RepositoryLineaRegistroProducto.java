package com.example.desrrollo.Repository;


import com.example.desrrollo.Api.LineaRegistroTransaccionProductoDTO;
import com.example.desrrollo.Entity.LineaRegistroTransaccionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RepositoryLineaRegistroProducto extends JpaRepository<LineaRegistroTransaccionProducto,Long> {

    @Query(value = "select rt.fecha, t.id_transaccion,rt.descripcion , rt.consecutivo_gravado , pe.nombre, l.cantidad ,l.valor_bruto " +
            "from  linea_registro_transaccion_producto l, registro_transaccion rt , transaccion t , persona pe " +
            "where l.consecutivo_gravado=rt.consecutivo_gravado " +
            "and t.id_transaccion=rt.transaccion  " +
            "and rt.tercero=pe.id_persona order by " +
            "l.id_linea_registro_transaccion_producto;" ,nativeQuery = true)


    List<LineaRegistroTransaccionProductoDTO>findAllLineaRegistroTransaccion();

}




