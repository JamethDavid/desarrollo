package com.example.desrrollo.Controller;

import com.example.desrrollo.Services.*;
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
    @GetMapping("/auxilio-inventario-pdf")
    public ResponseEntity<byte[]> exportPdf() throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportPdf());
    }
    @GetMapping("/lista-precio-pdf")
    public ResponseEntity<byte[]> exporListaPreciostPdf() throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
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
    @GetMapping("/reporte-zona-pdf/{zona}")
    public ResponseEntity<byte[]> exportToZona(@PathVariable String zona) throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return ResponseEntity.ok().headers(headers).body(IreporteService.exportToVentasZonaPdf(zona));
    }


}
