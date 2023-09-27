package com.example.desrrollo.Services;


import com.example.desrrollo.Api.*;
import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
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
public class ReporteService{
    private JasperPrint getReport(List<?> listDto, String jrxmlFileName) throws FileNotFoundException, JRException {
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listDto);
        File file = ResourceUtils.getFile("classpath:Reportes/" + jrxmlFileName + ".jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JasperPrint report = JasperFillManager.fillReport(jasperReport, null, dataSource);
        return report;
    }
    private JasperPrint getReportWithParameters(List<?> listDto, String jrxmlFileName,Map<String, Object> parameters ,String nombre) throws FileNotFoundException, JRException {
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listDto);
        File file = ResourceUtils.getFile("classpath:Reportes/" + jrxmlFileName + ".jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        parameters.put("nombre", nombre);
        JasperPrint report = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        return report;
    }

    public byte[] exportToPdf(List<LineaRegistroTransaccionProductoDTO> list) throws JRException, FileNotFoundException {
        return JasperExportManager.exportReportToPdf(getReport(list, "AuxilioInventario"));
    }

    public byte[] exportToListaPrecioPdf(List<ProductoUnidadMedidaListaPrecioDTO> list) throws JRException, FileNotFoundException {
        return JasperExportManager.exportReportToPdf(getReport(list, "ListaPrecios"));
    }

    public byte[] exportToListaExistentePdf(List<ProductoUnidadMedidaListaExistenteDTO> list) throws JRException, FileNotFoundException {
        return JasperExportManager.exportReportToPdf(getReport(list, "ListaExistente"));
    }
    public byte[] exportToInventarioValorizadoPdf(List<ProductoUnidadMedidaInventarioDTO> list) throws JRException, FileNotFoundException {
        return JasperExportManager.exportReportToPdf(getReport(list, "InventarioValorizado"));
    }
    public byte[] exportToLineaProductoPdf(List<ProductoLineaProductoDTO> list ,String nombre) throws JRException, FileNotFoundException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nombre",nombre);
        return JasperExportManager.exportReportToPdf(getReportWithParameters(list,"LineaProducto",parameters,nombre));
    }

}





