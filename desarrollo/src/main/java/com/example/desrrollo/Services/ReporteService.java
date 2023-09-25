package com.example.desrrollo.Services;


import com.example.desrrollo.Api.LineaRegistroTransaccionProductoDTO;
import com.example.desrrollo.Api.ProductoUnidadMedidaInventarioDTO;
import com.example.desrrollo.Api.ProductoUnidadMedidaListaExistenteDTO;
import com.example.desrrollo.Api.ProductoUnidadMedidaListaPrecioDTO;
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
        Map<String, Object> parameters = new HashMap<>();
        JasperPrint report = JasperFillManager.fillReport(jasperReport, null, dataSource);
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

}





