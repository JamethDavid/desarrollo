package com.example.desrrollo.Controller;

import com.example.desrrollo.Api.ProductoUnidadMedidaDTO;
import com.example.desrrollo.Api.ProductoUnidadMedidaInventarioDTO;
import com.example.desrrollo.Api.ProductoUnidadMedidaListaExistenteDTO;
import com.example.desrrollo.Api.ProductoUnidadMedidaListaPrecioDTO;
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

    @GetMapping("/listaPrecio")
    public List<ProductoUnidadMedidaListaPrecioDTO> getALListProductoUnidadMedidaDTOS(){
        return repositoryProducto.findAllProductoUnidadMedidaListaPrecioDTO();
    }


    @GetMapping("/listaExistente")
    public List<ProductoUnidadMedidaListaExistenteDTO> getALListProductoUnidadMedidaDTOSExistente(){
        return repositoryProducto.findAllProductoUnidadMedidaListaExistenteDTO();
    }



    @GetMapping("/listaInventarioValorizado")
    public List<ProductoUnidadMedidaInventarioDTO> getALListProductoUnidadMedidaDTOSValorizado(){
        return repositoryProducto.findAllProductoUnidadMedidaInventarioValorizadoDTO();
    }

}
