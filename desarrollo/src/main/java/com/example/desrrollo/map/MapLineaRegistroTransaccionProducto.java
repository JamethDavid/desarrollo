package com.example.desrrollo.map;

import com.example.desrrollo.Api.LineaRegistroTransaccionProductoDTO;
import com.example.desrrollo.Entity.LineaRegistroTransaccionProducto;
import com.example.desrrollo.Entity.Persona;
import com.example.desrrollo.Entity.RegistroTransaccion;
import com.example.desrrollo.Entity.Transaccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)


public interface MapLineaRegistroTransaccionProducto {

    @Mapping(source = "registroTransaccion.fecha",target = "fecha")
    @Mapping(source = "transaccion.idTransaccion",target = "transaccion")
    @Mapping(source = "registroTransaccion.descripcion", target = "descripcion")
    @Mapping(source = "registroTransaccion.consecutivoGravado",target = "consecutivoGravado")
    @Mapping(source = "persona.nombre" , target = "nombre")
    @Mapping(source = "lineaRegistroTransaccionProducto.cantidad",target = "cantidad")
    @Mapping(source = "lineaRegistroTransaccionProducto.valorBruto", target = "valorBruto")

     LineaRegistroTransaccionProductoDTO toGetLineaRegistroTransaccionProductoDto(Persona persona,
                                                                               LineaRegistroTransaccionProducto lineaRegistroTransaccionProducto , Transaccion transaccion ,
                                                                               RegistroTransaccion registroTransaccion);

    List<LineaRegistroTransaccionProductoDTO> toGetListeLineaRegistroTransaccionProductoDtos(List<Persona> personas , List<LineaRegistroTransaccionProducto> lineaRegistroTransaccionProductos, List<Transaccion> transaccions , List<RegistroTransaccion> registroTransaccions);
}
