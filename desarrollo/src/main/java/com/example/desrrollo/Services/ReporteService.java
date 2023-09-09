package com.example.desrrollo.Services;


import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteService {
    @Autowired
    private RepositoryLineaRegistroProducto repositoryLineaRegistroProducto;
/*
    public String exportReport(String reporFormat) throws FileNotFoundException, JRException {
        String path = "d:\\Users\\Usuario\\Downloads";
        List<LineaRegistroTransaccionProductoDTO> listLineaRegistroProducto = repositoryLineaRegistroProducto.findAllLineaRegistroTransaccion();
        File file = ResourceUtils.getFile("classpath:AuxilioInventario.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listLineaRegistroProducto);

        JasperPrint jasperPrint =  JasperFillManager.fillReport(jasperReport,null ,dataSource);

        if (reporFormat.equalsIgnoreCase("pdf")){

          JasperExportManager.exportReportToPdfFile(jasperPrint,path + "\\AuxilioInventario.pdf");

        }

        return "Report generated" + path;
    }


 */

}
