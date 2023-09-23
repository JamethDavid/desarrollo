package com.example.desrrollo.Controller;

import com.example.desrrollo.Api.*;
import com.example.desrrollo.Repository.RepositoryKardex;
import com.example.desrrollo.Repository.RepositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ControllerProducto {

    @Autowired
    private RepositoryProducto repositoryProducto;
    @Autowired
    private RepositoryKardex repositoryKardex;

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
    @GetMapping("/listaInventario-kardex/{idVendedor}")
    public List<KardexDTO> getKardexDTO(@PathVariable String idVendedor){
    return repositoryProducto.findAllByIdKardex(idVendedor);
    }

    @GetMapping("/linea-producto/{nombre}")
    public List<ProductoLineaProductoDTO> getProductoLineaDTO(@PathVariable String nombre){
        return repositoryProducto.findAllByNombre(nombre);
    }
    @GetMapping("/salida-inventario/{fechaInicial}/{fechaFinal}")
    public List<RegistroTransaccionInformeSalidaInventarioDTO> getRegistroTransacionSalidaInventarioDTO(
             @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicial
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal){
        return repositoryProducto.findAllByFecha(fechaInicial,fechaFinal);
    }
}
