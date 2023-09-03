package com.example.desrrollo.Servicio;


import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class ReporteService {
    private RepositoryLineaRegistroProducto repositoryLineaRegistroProducto;

    private String exportReport(String reporFormat) throws FileNotFoundException {
        List<Object[]> listLineaRegistroProducto = repositoryLineaRegistroProducto.findAllLineaRegistroTransaccion();
        File file = ResourceUtils.getFile("classpath:AuxilioInventario.jrxml");

        return null;
    }
}
