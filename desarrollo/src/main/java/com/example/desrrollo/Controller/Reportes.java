package com.example.desrrollo.Controller;

import com.example.desrrollo.Services.ReporteService;
import com.example.desrrollo.Services.ReporteServiceListaExistente;
import com.example.desrrollo.Services.ReporteServiceListaPrecio;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class Reportes {
@Autowired
    private ReporteService reporteService;
@Autowired
    private ReporteServiceListaPrecio reporteServiceListaPrecio;
@Autowired
    private ReporteServiceListaExistente reporteServiceListaExistente;
    @GetMapping("/reportes/auxilio-inventario")
    public String generaReporte() {
        try {
            // Obtén la ruta del directorio de descargas del usuario actual
            String userHome = System.getProperty("user.home");
            String downloadsDir = userHome + File.separator + "informes";
            System.out.println("Ruta del archivo PDF: " + downloadsDir);

            // Llama al método de exportación con la ruta completa del archivo PDF
            String generatedFilePath = reporteService.exportReport(downloadsDir);

            return "Reporte generado en la ruta: " + generatedFilePath;
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
            return "Error al generar el informe: " + e.getMessage();
        }

    }

    @GetMapping("/reportes/Lista-precio/{format}")
    public String generaReporteListaPrecio(@PathVariable String format) {
        try {
            String path = "C:\\Users\\LENOVO_THINCENTRE\\Desktop";

            String fileName = reporteServiceListaPrecio.exportReport(format, path);
            return "Reporte generado en la ruta: " + fileName;
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
            return "Error al generar el informe: " + e.getMessage();
        }
    }
    @GetMapping("/reportes/Lista-existente/{format}")
    public String generaReporteListaExistente(@PathVariable String format) {
        try {
            String path = "C:\\Users\\LENOVO_THINCENTRE\\Desktop";

            String fileName = reporteServiceListaExistente.exportReport(format, path);
            return "Reporte generado en la ruta: " + fileName;
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
            return "Error al generar el informe: " + e.getMessage();
        }
    }
}
