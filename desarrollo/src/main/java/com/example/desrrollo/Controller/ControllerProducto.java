package com.example.desrrollo.Controller;

import com.example.desrrollo.Api.*;
import com.example.desrrollo.Entity.EmpresaC;
import com.example.desrrollo.Entity.Usuario;
import com.example.desrrollo.Query.*;
import com.example.desrrollo.Query.ReferenciaClienteDto;
import com.example.desrrollo.Repository.*;
import com.example.desrrollo.Services.IserviceQuery;
import com.example.desrrollo.Services.UsuarioService;
import com.example.desrrollo.config.DataSourceMap;
import com.example.desrrollo.util.ConstantesBD;
import com.example.desrrollo.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
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
    @Autowired
    private RepositoryLineaRegistroProducto repositoryLineaRegistroProducto;
    @Autowired
    private RepositoryEmpresaC repositoryEmpresa;
    @Autowired
    protected UsuarioService usuarioService;
    protected ObjectMapper mapper;
    @Autowired
    private DataSourceMap dataSources;

    @GetMapping("/listaPrecio")
    public List<ProductoUnidadMedidaListaPrecioDTO> getALListProductoUnidadMedidaDTOS(){
        return repositoryProducto.findAllProductoUnidadMedidaListaPrecioDTO();
    }
    @GetMapping("/listaPrecio/{token}")
    public List<ProductoUnidadMedidaListaPrecioDTO> getALListProductoUnidadMedidaDTOStoken(@PathVariable String token){
        System.out.println("Entro a Linea de producto -> getLineaProducto.");
        if (dataSources.getDataSourceMap().containsKey(token)) // Valida si el usuario esta autenticado. System.out.println("SESION: " + token);
        {
            ConstantesBD.session = token;
        }
        return repositoryProducto.findAllProductoUnidadMedidaListaPrecioDTO();
    }

    @GetMapping("/listaExistente")
    public List<ProductoUnidadMedidaListaExistenteDTO> getALListProductoUnidadMedidaDTOSExistente(){
        return repositoryProducto.findAllProductoUnidadMedidaListaExistenteDTO();
    }
    @GetMapping("/listaExistente/{token}")
    public List<ProductoUnidadMedidaListaExistenteDTO> getALListProductoUnidadMedidaDTOSExistentetoken(@PathVariable String token){
        System.out.println("Entro a Linea de producto -> getLineaProducto.");
        if (dataSources.getDataSourceMap().containsKey(token)) // Valida si el usuario esta autenticado. System.out.println("SESION: " + token);
        {
            ConstantesBD.session = token;
        }
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

    //@GetMapping("/linea-producto/{nombre}")
    //public List<ProductoLineaProductoDTO> getProductoLineaDTO(@PathVariable String nombre){
    //    return repositoryProducto.findAllByNombre(nombre);
    //}
    @GetMapping("/linea-zona/{nombre}/{token}")
    public List<ZonaReporteVentaDTO> getZonaLineaDTO(@PathVariable String nombre, @PathVariable String token){
        System.out.println("Entro a Linea de producto -> getLineaProducto.");
        if (dataSources.getDataSourceMap().containsKey(token)) // Valida si el usuario esta autenticado. System.out.println("SESION: " + token);
        {
            ConstantesBD.session = token;
        }
        return repositoryRegistroTransacion.findAllZona(nombre);
    }


    @GetMapping("/venta-linea-producto/{fechaInicial}/{fechaFinal}")
    public List<InformeVentaLineaProductoDTO> getInformeVentaLineaProductoDTO(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicial
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal){
        return repositoryLineaProducto.findAllByLineaProductoAndFecha(fechaInicial,fechaFinal);
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
    @GetMapping("/reporte-cliente/{fechaInicial}/{fechaFinal}/{idPersona}")
    public List<RegistroTransaccionInformeClienteDTO> getReporteTransaccionInformeClienteDTO(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicial
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal,
            @PathVariable String idPersona){
        return repositoryRegistroTransacion.findByFechaAndPersona(fechaInicial,fechaFinal,idPersona);
    }
    @GetMapping("/reporte-acomulado-venta-producto/{fechaInicial}/{fechaFinal}/{idProducto}")
    public List<AcomuladoVentasProductoDTO> getReporteAcomuladoVentaProductoDTO(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicial
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal,
            @PathVariable String idProducto){
        return repositoryLineaRegistroProducto.findAllByAcomuladoVentaProducto(fechaInicial,fechaFinal,idProducto);
    }

    @GetMapping("/linea-empresa")
    public List<EmpresaC> getListEmpresa(){
        return repositoryEmpresa.findAll();
    }

    /*@GetMapping("/linea-empresaDTO")
    public List<EmpresaDTO> getListEmpresaDTO(){
        return repositoryEmpresa.findAllEmpresa();
    }
     */
    @PostMapping("/login")
    public RestResponse login(@RequestBody String usuarioJS, HttpSession session)
            throws JsonParseException, JsonMappingException, IOException, SQLException {

        System.out.println("Entro a login.");
        this.mapper = new ObjectMapper();
        Usuario dataForm = this.mapper.readValue(usuarioJS, Usuario.class);
        ConstantesBD.session = ConstantesBD.TOKEN;

        System.out.println("USUARIO: " + dataForm.getUsuario() + " - SESION: " + session.getId());

        /** Consulta en BD el usuario */
        Usuario dataBd = usuarioService.findByUsuario(dataForm.getUsuario());

        if (dataBd != null) {

            if (usuarioService.validarFecha(dataBd.getFechafinal()) <= 0) {
                return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
                        "Su usuario ha expirado, por favor comuniquese con su ascesor");
            }



            /** Valida los datos de la consulta con los datos del formulario */
            if (dataBd.getPassword().equals(dataForm.getPassword())
                    && dataBd.getUsuario().equals(dataForm.getUsuario())) {

                /** Consulta en BD la empresa del Usuario */
                EmpresaC empresaC = repositoryEmpresa.findByUsuario(dataBd.getUsuario());

                if (empresaC != null && !empresaC.getPoolEmpresaAlterna().equals("")) { // Valida Si existe una
                    // empresa para este
                    // usuario.

                    System.out.println("BD CLIENTE: " + empresaC.getPoolEmpresa());
                    System.out.println("BD CLIENTE ALTERNA: " + empresaC.getPoolEmpresaAlterna());
                    ConstantesBD.bd = empresaC.getPoolEmpresaAlterna();

                    dataSources.addDataSource(session.getId(), dataSources.dataSource());
                    return new RestResponse(HttpStatus.OK.value(), "Sesión iniciada.", session.getId());
                } else {
                    return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
                            "Este usuario no se encuentra asociado, Comuniquese con la empresa.");
                }
            } else {
                return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
                        "Usuario o Contraseña incorrectos, intente nuevamente.");
            }
        } else {
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
                    "Usuario o Contraseña incorrectos, intente nuevamente.");
        }
        // return null;
    }
    //---------------------desarrolla-----------------------//
    @GetMapping("/linea-producto/{token}")
    public List<ProductoNombreDTO> getProductoLineaDTO(@PathVariable String token) {
        System.out.println("Entro a Linea de producto -> getLineaProducto.");
        if (dataSources.getDataSourceMap().containsKey(token)) // Valida si el usuario esta autenticado. System.out.println("SESION: " + token);
        {
            ConstantesBD.session = token;
        }
        return iserviceQuery.findAllByName();
    }
    @GetMapping("/lista-kardex/{token}")
    public List<KardexReferenciaDTO> getKardex(@PathVariable String token){
        System.out.println("Entro a Linea de producto -> getLineaProducto.");
        if (dataSources.getDataSourceMap().containsKey(token)) // Valida si el usuario esta autenticado. System.out.println("SESION: " + token);
        {
            ConstantesBD.session = token;
        }
        return iserviceQuery.findAllByNameKardexDtos();
    }
    @GetMapping("/producto-id/{idproducto}/{token}")
    public KardexReferenciaDTO getProductoIdDTO(@PathVariable String idproducto,@PathVariable String token){
        System.out.println("Entro a Linea de producto -> getLineaProducto.");
        if (dataSources.getDataSourceMap().containsKey(token)) // Valida si el usuario esta autenticado. System.out.println("SESION: " + token);
        {
            ConstantesBD.session = token;
        }
        return iserviceQuery.findByIdVendedorKardex(idproducto);
    }
    @GetMapping("/lista-cliente/{token}")
    public List<ReferenciaClienteDto> getAllClienteListDTO(@PathVariable String token){
        System.out.println("Entro a Linea de producto -> getLineaProducto.");
        if (dataSources.getDataSourceMap().containsKey(token)) // Valida si el usuario esta autenticado. System.out.println("SESION: " + token);
        {
            ConstantesBD.session = token;
        }
        return iserviceQuery.findAllCliente();
    }
    @GetMapping("/lista-zona/{token}")
    public List<ReferenciaZonaDTO> getAllZonaListDTO(@PathVariable String token){
        System.out.println("Entro a Linea de producto -> getLineaProducto.");
        if (dataSources.getDataSourceMap().containsKey(token)) // Valida si el usuario esta autenticado. System.out.println("SESION: " + token);
        {
            ConstantesBD.session = token;
        }
        return iserviceQuery.findAllZona();
    }

  /*  @GetMapping("/linea-zona-nombre/{nombre}/{token}")
    public List<ZonaReporteVentaDTO> getZonaLineaDTO(@PathVariable String nombre, @PathVariable String token){
        System.out.println("Entro a Linea de producto -> getLineaProducto.");
        if (dataSources.getDataSourceMap().containsKey(token)) // Valida si el usuario esta autenticado. System.out.println("SESION: " + token);
        {
            ConstantesBD.session = token;
        }
        return iserviceQuery.findAllZonaReporteNombre(nombre);
    }


   */
}
