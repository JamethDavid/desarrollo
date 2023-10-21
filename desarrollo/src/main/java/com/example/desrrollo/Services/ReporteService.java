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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    private JasperPrint getReportWithParametersFecha(List<?> listDto, String jrxmlFileName,Map<String, Object> parameters ,LocalDateTime fechaIncio, LocalDateTime fechaFinal) throws FileNotFoundException, JRException {
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listDto);
        File file = ResourceUtils.getFile("classpath:Reportes/" + jrxmlFileName + ".jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        parameters.put("fechaInicio",fechaIncio);
        parameters.put("fechaFinal",fechaFinal );
        JasperPrint report = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        return report;
    }

    private JasperPrint getReportWithParametersFechaAndNombre(List<?> listDto, String jrxmlFileName,Map<String, Object> parameters ,LocalDateTime fechaInicio, LocalDateTime fechaFinal ,String nombre) throws FileNotFoundException, JRException {
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listDto);
        File file = ResourceUtils.getFile("classpath:Reportes/" + jrxmlFileName + ".jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        parameters.put("fechaInicio",fechaInicio);
        parameters.put("fechaFinal",fechaFinal);
        parameters.put("zona",nombre);
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
    public byte[] exportToEntradaInventarioPdf(List<RegistroTransaccionInformeEntradaInventarioDTO> list, LocalDateTime fechaInicio, LocalDateTime fechaFinal) throws JRException, FileNotFoundException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fechaInical", fechaInicio);
        parameters.put("fechaFinal", fechaFinal);
        return JasperExportManager.exportReportToPdf(getReportWithParametersFecha(list, "EntradaDeInventario", parameters, fechaInicio,fechaFinal));
    }
    public byte[] exportToSalidaInventarioPdf(List<RegistroTransaccionInformeSalidaInventarioDTO> list, LocalDateTime fechaInicio, LocalDateTime fechaFinal) throws JRException, FileNotFoundException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fechaInical", fechaInicio);
        parameters.put("fechaFinal", fechaFinal);
        return JasperExportManager.exportReportToPdf(getReportWithParametersFecha(list, "SalidaDeInventario", parameters, fechaInicio,fechaFinal));
    }
    public byte[] exportToRentabilidadPdf(List<ProductoRentabilidadDTO> list, LocalDateTime fechaInicio, LocalDateTime fechaFinal) throws JRException, FileNotFoundException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fechaInical", fechaInicio);
        parameters.put("fechaFinal", fechaFinal);
        return JasperExportManager.exportReportToPdf(getReportWithParametersFecha(list, "InformeRentabilidad", parameters, fechaInicio,fechaFinal));
    }
    public byte[] exportToKardexPdf(List<KardexDTO> list ,String idVendedor) throws JRException, FileNotFoundException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("idVendedor",idVendedor);
        return JasperExportManager.exportReportToPdf(getReportWithParameters(list,"informeKardex",parameters,idVendedor));
    }

    public byte[] exportToVentasZonaPdf(List<ZonaReporteVentaDTO> list ,String zona) throws JRException, FileNotFoundException {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("zona",zona);
        return JasperExportManager.exportReportToPdf(getReportWithParameters(list,"LineaProducto",parameters,zona));
    }

}





