package com.example.desrrollo.Controller;

import com.example.desrrollo.Services.ReporteService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/api")
public class Reportes {
@Autowired
    private ReporteService reporteService;
    @GetMapping("/report/{format}")
    public String generaReporte(@PathVariable String format) {
        try {
            String path = "C:\\Users\\LENOVO_THINCENTRE\\Desktop";

            String fileName = reporteService.exportReport(format, path);
            return "Reporte generado en la ruta: " + fileName;
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
            return "Error al generar el informe: " + e.getMessage();
        }
    }
}
