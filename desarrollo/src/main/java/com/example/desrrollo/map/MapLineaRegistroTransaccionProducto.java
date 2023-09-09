package com.example.desrrollo.map;

import com.example.desrrollo.Entity.LineaRegistroTransaccionProducto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()


public interface MapLineaRegistroTransaccionProducto {
    MapLineaRegistroTransaccionProducto mapper = Mappers.getMapper(MapLineaRegistroTransaccionProducto.class);

   /* @Mapping(source = "registroTransaccion.fecha",target = "fecha")
    @Mapping(source = "transaccion.idTransaccion",target = "transaccion")
    @Mapping(source = "registroTransaccion.descripcion", target = "descripcion")
    @Mapping(source = "registroTransaccion.consecutivoGravado",target = "consecutivoGravado")
    @Mapping(source = "persona.nombre" , target = "nombre")
    @Mapping(source = "lineaRegistroTransaccionProducto.cantidad",target = "cantidad")
    @Mapping(source = "lineaRegistroTransaccionProducto.valorBruto", target = "valorBruto")
*/
    // LineaRegistroTransaccionProductoDTO toGetLineaRegistroTransaccionProductoDto(LineaRegistroTransaccionProducto lineaRegistroTransaccionProducto);

   // List<LineaRegistroTransaccionProductoDTO> toGetListeLineaRegistroTransaccionProductoDtos(List<LineaRegistroTransaccionProducto> lineaRegistroTransaccionProductos);
}
