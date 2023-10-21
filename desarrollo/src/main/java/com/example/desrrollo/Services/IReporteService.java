package com.example.desrrollo.Services;

import com.example.desrrollo.Api.ProductoLineaProductoDTO;
import com.example.desrrollo.Api.ProductoUnidadMedidaListaPrecioDTO;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

public interface IReporteService {
    byte[] exportPdf() throws JRException, FileNotFoundException;
    byte[] exportToListaPrecioPdf() throws JRException, FileNotFoundException;
    byte[] exportToListaExistentePdf() throws JRException, FileNotFoundException;
    byte[] exportToInventarioValorizadoPdf() throws JRException, FileNotFoundException;
    byte[] exportToLineaProductoPdf(String nombre) throws JRException, FileNotFoundException;
    byte[] exportToEntradaInventarioPdf(LocalDateTime fechaInicio, LocalDateTime fechaFinal) throws JRException, FileNotFoundException;
    byte[] exportToSalidaInventarioPdf(LocalDateTime fechaInicio, LocalDateTime fechaFinal) throws JRException, FileNotFoundException;
    byte[] exportToRentabilidadPdf(LocalDateTime fechaInicio, LocalDateTime fechaFinal) throws JRException, FileNotFoundException;
    byte[] exportToKardexPdf(String idVendedor) throws JRException, FileNotFoundException;
    byte[] exportToVentasZonaPdf(String nombre) throws JRException, FileNotFoundException;




}
