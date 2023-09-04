package com.example.desrrollo.Servicio;


import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
@Service
public class ReporteService {
    private RepositoryLineaRegistroProducto repositoryLineaRegistroProducto;

    private String exportReport(String reporFormat) throws FileNotFoundException, JRException {
        String path = "d:\\Users\\Usuario\\Downloads";
        List<Object[]> listLineaRegistroProducto = repositoryLineaRegistroProducto.findAllLineaRegistroTransaccion();
        File file = ResourceUtils.getFile("classpath:AuxilioInventario.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listLineaRegistroProducto);

        JasperPrint jasperPrint =  JasperFillManager.fillReport(jasperReport,null ,dataSource);

        if (reporFormat.equalsIgnoreCase("pdf")){

          JasperExportManager.exportReportToPdfFile(jasperPrint,path + "\\AuxilioInventario.pdf");

        }



        return "Report generated" + path;
    }
}
