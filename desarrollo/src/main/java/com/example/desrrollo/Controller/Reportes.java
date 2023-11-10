package com.example.desrrollo.Controller;

import com.example.desrrollo.Services.*;
import com.example.desrrollo.config.DataSourceMap;
import com.example.desrrollo.util.ConstantesBD;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class Reportes {
@Autowired
private  IReporteService IreporteService;
    protected ObjectMapper mapper;
    @Autowired
    private DataSourceMap dataSources;
    @GetMapping("/auxilio-inventario-pdf")
    public ResponseEntity<byte[]> exportPdf() throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportPdf());
    }
    @GetMapping("/lista-precio-pdf/{token}")
    public ResponseEntity<byte[]> exporListaPreciostPdf(@PathVariable String token) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        if (dataSources.getDataSourceMap().containsKey(token)) // Valida si el usuario esta autenticado. System.out.println("SESION: " + token);
        {
            ConstantesBD.session = token;
        }
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToListaPrecioPdf());
    }
    @GetMapping("/lista-existente-pdf")
    public ResponseEntity<byte[]> exportToListaExistentePdf() throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToListaExistentePdf());
    }
    @GetMapping("/lista-inventario-valorizado-pdf")
    public ResponseEntity<byte[]> exportToInventarioValorizadoPdf() throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToInventarioValorizadoPdf());
    }
    @GetMapping("/reporte-pedido-pendiente-pdf")
    public ResponseEntity<byte[]> exporToReportePedidoPendientePdf() throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToReportePedidoPendientePdf());
    }

    @GetMapping("/lista-producto-pdf/{nombre}")
    public ResponseEntity<byte[]> exportToListaProductoPdf(@PathVariable String nombre) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToLineaProductoPdf(nombre));
    }
    @GetMapping("/entrada-inventario-pdf/{fechaInicio}/{fechaFinal}")
    public ResponseEntity<byte[]> exportToEntradaInventario(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToEntradaInventarioPdf(fechaInicio,fechaFinal));
    }
    @GetMapping("/salida-inventario-pdf/{fechaInicio}/{fechaFinal}")
    public ResponseEntity<byte[]> exportToSalidaInventario(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToSalidaInventarioPdf(fechaInicio,fechaFinal));
    }


    @GetMapping("/producto-rentabilidad-pdf/{fechaInicio}/{fechaFinal}")
    public ResponseEntity<byte[]> exportToRentabilidad(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToRentabilidadPdf(fechaInicio,fechaFinal));
    }
    @GetMapping("/reporte-kardex-pdf/{idVendedor}")
    public ResponseEntity<byte[]> exportToKardex(@PathVariable String idVendedor) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToKardexPdf(idVendedor));
    }

    @GetMapping("/reporte-zona-pdf/{nombre}")
    public ResponseEntity<byte[]> exportToZona(@PathVariable String nombre) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToVentasZonaPdf(nombre));
    }
    @GetMapping("/reporte-cliente-pdf/{fechaInicio}/{fechaFinal}/{idPersona}")
    public ResponseEntity<byte[]> exportToReporteCliente(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal,
            @PathVariable String idPersona) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToReporteClientePdf(fechaInicio,fechaFinal,idPersona));
    }
    @GetMapping("/reporte-acomulado-venta-producto-pdf/{fechaInicio}/{fechaFinal}/{idProducto}")
    public ResponseEntity<byte[]> exportToReporteAcomuladoVentaProducto(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal,
            @PathVariable String idProducto) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToReporteAcomuladoVentaProductoPdf(fechaInicio,fechaFinal,idProducto));
    }
    @GetMapping("/reporte-venta-linea-producto-pdf/{fechaInicio}/{fechaFinal}")
    public ResponseEntity<byte[]> exportToReporteVentaLineaProducto(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio
            ,@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime fechaFinal) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToInformeVentaLineaFechaPdf(fechaInicio,fechaFinal));
    }
    @GetMapping("/reporte-zona-venta-fecha-pdf")
    public ResponseEntity<byte[]> exportToZonaFecha() throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToReporteVentaZonaFechaPdf());
    }

}
