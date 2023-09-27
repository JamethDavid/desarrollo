package com.example.desrrollo.Controller;

import com.example.desrrollo.Services.*;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
@CrossOrigin(origins = {"http://localhost:4200"})
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



}
