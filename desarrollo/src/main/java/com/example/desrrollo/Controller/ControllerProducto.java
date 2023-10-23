package com.example.desrrollo.Controller;

import com.example.desrrollo.Api.*;
import com.example.desrrollo.Entity.Kardex;
import com.example.desrrollo.Entity.Producto;
import com.example.desrrollo.Query.*;
import com.example.desrrollo.Query.ReferenciaClienteDto;
import com.example.desrrollo.Repository.RepositoryLineaProducto;
import com.example.desrrollo.Repository.RepositoryProducto;
import com.example.desrrollo.Repository.RepositoryRegistroTransacion;
import com.example.desrrollo.Services.IserviceQuery;
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
    private IserviceQuery iserviceQuery;
    @Autowired
    private RepositoryProducto repositoryProducto;
    @Autowired
    private RepositoryLineaProducto repositoryLineaProducto;
    @Autowired
    private RepositoryRegistroTransacion repositoryRegistroTransacion;

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
    @GetMapping("/linea-zona/{nombre}")
    public List<ZonaReporteVentaDTO> getZonaLineaDTO(@PathVariable String nombre){
        return repositoryRegistroTransacion.findAllZona(nombre);
    }
    @GetMapping("/venta-linea-producto/{fechaInicial}/{fechaFinal}")
    public List<InformeVentaLineaProductoDTO> getInformeVentaLineaProductoDTO(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicial
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal){
        return repositoryLineaProducto.findAllByLineaProductoAndFAndFecha(fechaInicial,fechaFinal);
    }
    @GetMapping("/salida-inventario/{fechaInicial}/{fechaFinal}")
    public List<RegistroTransaccionInformeSalidaInventarioDTO> getRegistroTransacionSalidaInventarioDTO(
             @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicial
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal){
        return repositoryRegistroTransacion.findAllByFechaSalida(fechaInicial,fechaFinal);
    }
    @GetMapping("/entrada-inventario/{fechaInicial}/{fechaFinal}")
    public List<RegistroTransaccionInformeEntradaInventarioDTO> getRegistroTransacionEntradaInventarioDTO(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicial
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal){
        return repositoryRegistroTransacion.findAllByFechaEntarda(fechaInicial,fechaFinal);
    }

    @GetMapping("/rentabilidad-producto/{fechaInicial}/{fechaFinal}")
    public List<ProductoRentabilidadDTO> getProductoRentabilidadDTO(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicial
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal){
        return repositoryProducto.findAllByFechaRentabilidad(fechaInicial,fechaFinal);
    }

    //---------------------desarrolla-----------------------//
    @GetMapping("/linea-producto")
    public List<ProductoNombreDTO> getProductoLineaDTO(){
        return iserviceQuery.findAllByName();
    }
    @GetMapping("/lista-kardex")
    public List<KardexReferenciaDTO> getKardex(){
        return iserviceQuery.findAllByNameKardexDtos(); }
    @GetMapping("/producto-id/{idproducto}")
    public KardexReferenciaDTO getProductoIdDTO(@PathVariable String idproducto){
        return iserviceQuery.findByIdVendedorKardex(idproducto);
    }
    @GetMapping("/lista-cliente")
    public List<ReferenciaClienteDto> getAllClienteListDTO(){
        return iserviceQuery.findAllCliente();
    }
    @GetMapping("/lista-zona")
    public List<ReferenciaZonaDTO> getAllZonaListDTO(){
        return iserviceQuery.findAllZona();
    }
}
