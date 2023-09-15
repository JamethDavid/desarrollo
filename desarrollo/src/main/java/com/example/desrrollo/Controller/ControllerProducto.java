package com.example.desrrollo.Controller;

import com.example.desrrollo.Api.ProductoUnidadMedidaDTO;
import com.example.desrrollo.Repository.RepositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ControllerProducto {

    @Autowired
    private RepositoryProducto repositoryProducto;
/*
    @GetMapping("/lista")
    public List<ProductoUnidadMedidaDTO> getALListProductoUnidadMedidaDTOS(){
        return repositoryProducto.findAllProductoUnidadMedidaDTO();
    }
    @GetMapping("/listaExistente")
    public List<ProductoUnidadMedidaDTO> getALListProductoUnidadMedidaDTOSExistente(){
        return repositoryProducto.findAllProductoUnidadMedidaDTOListaExistente();
    }


 */
    @GetMapping("/listaInventarioValorizado")
    public List<ProductoUnidadMedidaDTO> getALListProductoUnidadMedidaDTOSValorizado(){
        return repositoryProducto.findAllProductoUnidadMedidaDTOInentarioValorizado();
    }

}
