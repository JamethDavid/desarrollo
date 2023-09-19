package com.example.desrrollo.Services;

import com.example.desrrollo.Api.ProductoUnidadMedidaListaPrecioDTO;
import com.example.desrrollo.Repository.RepositoryProducto;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReporteServiceListaPrecio {
    @Autowired
    private RepositoryProducto repositoryProducto;
    public String exportReport(String reportFormat, String outputPath) throws FileNotFoundException, JRException {
        List<ProductoUnidadMedidaListaPrecioDTO> listDto = repositoryProducto.findAllProductoUnidadMedidaListaPrecioDTO();
        File file = ResourceUtils.getFile("classpath:Reportes/ListaPrecios.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listDto);
        Map<String, Object> parameters = new HashMap<>();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        if ("pdf".equalsIgnoreCase(reportFormat)) {
            String pdfFilePath = outputPath + "\\ListaPrecios.pdf"; // Ruta del archivo PDF de salida
            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFilePath);
            return pdfFilePath;
        } else {
            throw new IllegalArgumentException("Formato de informe no válido: " + reportFormat);
        }
    }
}

