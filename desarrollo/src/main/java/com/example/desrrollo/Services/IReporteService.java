package com.example.desrrollo.Services;

import com.example.desrrollo.Api.ProductoUnidadMedidaListaPrecioDTO;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.List;

public interface IReporteService {
    byte[] exportPdf() throws JRException, FileNotFoundException;
    byte[] exportToListaPrecioPdf() throws JRException, FileNotFoundException;
    byte[] exportToListaExistentePdf() throws JRException, FileNotFoundException;

}
