package com.example.desrrollo.Services;

import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import com.example.desrrollo.Repository.RepositoryProducto;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class ReportesPDF {
    @Autowired
    private RepositoryProducto repositoryProducto;
    @Autowired
    private RepositoryLineaRegistroProducto repositoryLineaRegistroProducto;
    @Autowired
    private ReporteService reporteService;

    public byte[] exportarPdf() throws JRException, FileNotFoundException {
        return reporteService.exportToPdf(repositoryLineaRegistroProducto.findAllByDTO());
    }

    public byte[] exportarListaPreciaPdf() throws JRException, FileNotFoundException {
        return reporteService.exportToListaPrecioPdf(repositoryProducto.findAllProductoUnidadMedidaListaPrecioDTO());
    }
}
