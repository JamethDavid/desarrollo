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
    public String generaRepor(@PathVariable String format) throws JRException, FileNotFoundException {
    return reporteService.exportReport(format);
}

}
