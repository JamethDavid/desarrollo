package com.example.desrrollo.Services;

import com.example.desrrollo.Api.LineaRegistroTransaccionProductoDTO;
import com.example.desrrollo.Api.ResponseLineaRegistroTransaccionProducto;
import com.example.desrrollo.Entity.LineaRegistroTransaccionProducto;
import com.example.desrrollo.Entity.Persona;
import com.example.desrrollo.Entity.Transaccion;
import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineaRegistroTransaccionProductoImpl{
    @Autowired
    private RepositoryLineaRegistroProducto repositoryLineaRegistroProducto;
    private LineaRegistroTransaccionProductoDTO lineaRegistroTransaccionProductoDTO;

    public List<ResponseLineaRegistroTransaccionProducto> getAllResponseLineaRegistroProducto(){
        return repositoryLineaRegistroProducto.findAll()
                .stream()
                .map(this::convertiEntityResponse)
                .collect(Collectors.toList());
    }

    private ResponseLineaRegistroTransaccionProducto convertiEntityResponse(LineaRegistroTransaccionProducto lineaRegistroTransaccionProducto){
        ResponseLineaRegistroTransaccionProducto responseLineaRegistroTransaccionProducto = new ResponseLineaRegistroTransaccionProducto();

        responseLineaRegistroTransaccionProducto.setIdLineaRegistroTransaccionProducto((lineaRegistroTransaccionProducto.getIdLineaRegistroTransaccionProducto()));
        responseLineaRegistroTransaccionProducto.setTransaccion(lineaRegistroTransaccionProducto.getTransaccion());
        responseLineaRegistroTransaccionProducto.setDescuento(lineaRegistroTransaccionProducto.getDescuento());
        responseLineaRegistroTransaccionProducto.setAsesor(lineaRegistroTransaccionProducto.getAsesor());
        responseLineaRegistroTransaccionProducto.setCantidad(lineaRegistroTransaccionProducto.getCantidad());
        responseLineaRegistroTransaccionProducto.setValorBruto(lineaRegistroTransaccionProducto.getValorBruto());
        return responseLineaRegistroTransaccionProducto;
    }

    public List<LineaRegistroTransaccionProductoDTO> getAllListaLineaRegistroDTO(){
        return repositoryLineaRegistroProducto.findAllLineaRegistroTransaccion()
                .stream().map(this::convertiEntityDTO).forEach();

    }



    private List<LineaRegistroTransaccionProductoDTO>convertiEntityDTO(LineaRegistroTransaccionProducto lineaRegistroTransaccionProducto
            , Persona persona , Transaccion transaccion){
        for (LineaRegistroTransaccionProducto lineaRegistroTransaccionProducto : lineaRegistroTransaccionProductos) {
            List<LineaRegistroTransaccionProductoDTO> listaDTOS = new ArrayList<>();
            LineaRegistroTransaccionProductoDTO lineaRegistroTransaccionProductoDTO = new LineaRegistroTransaccionProductoDTO();
            lineaRegistroTransaccionProductoDTO.setTransaccion(transaccion.getIdTransaccion());
            lineaRegistroTransaccionProductoDTO.setNombre(persona.getNombre());
            lineaRegistroTransaccionProductoDTO.setCantidad(lineaRegistroTransaccionProducto.getCantidad());
            lineaRegistroTransaccionProductoDTO.setValorBruto(lineaRegistroTransaccionProducto.getValorBruto());
        }
        listaDTOS.add(lineaRegistroTransaccionProductoDTO);


        return listaDTOS;
    }



}
