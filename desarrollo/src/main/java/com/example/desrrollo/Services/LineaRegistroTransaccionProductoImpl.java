package com.example.desrrollo.Services;

import com.example.desrrollo.Api.ResponseLineaRegistroTransaccionProducto;
import com.example.desrrollo.Entity.LineaRegistroTransaccionProducto;
import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineaRegistroTransaccionProductoImpl{
    @Autowired
    private RepositoryLineaRegistroProducto repositoryLineaRegistroProducto;

    public List<ResponseLineaRegistroTransaccionProducto> getAllResponseLineaRegistroProducto(){
        return repositoryLineaRegistroProducto.findAll()
                .stream()
                .map(this::convertiEntityResponse)
                .collect(Collectors.toList());
    }

    private ResponseLineaRegistroTransaccionProducto convertiEntityResponse(LineaRegistroTransaccionProducto lineaRegistroTransaccionProducto){
        ResponseLineaRegistroTransaccionProducto responseLineaRegistroTransaccionProducto = new ResponseLineaRegistroTransaccionProducto();

        lineaRegistroTransaccionProducto.setIdLineaRegistroTransaccionProducto((lineaRegistroTransaccionProducto.getIdLineaRegistroTransaccionProducto()));
        lineaRegistroTransaccionProducto.setTransaccion(lineaRegistroTransaccionProducto.getTransaccion());
        lineaRegistroTransaccionProducto.setDescuento(lineaRegistroTransaccionProducto.getDescuento());
        lineaRegistroTransaccionProducto.setAsesor(lineaRegistroTransaccionProducto.getAsesor());
        lineaRegistroTransaccionProducto.setCantidad(lineaRegistroTransaccionProducto.getCantidad());
        lineaRegistroTransaccionProducto.setValorBruto(lineaRegistroTransaccionProducto.getValorBruto());


        return responseLineaRegistroTransaccionProducto;
    }

}
