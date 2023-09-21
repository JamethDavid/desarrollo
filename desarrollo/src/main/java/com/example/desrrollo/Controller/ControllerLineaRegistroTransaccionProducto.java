package com.example.desrrollo.Controller;

import com.example.desrrollo.Api.LineaRegistroTransaccionProductoDTO;
import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import com.example.desrrollo.Services.ServiceRepositiroLRP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ControllerLineaRegistroTransaccionProducto {
    @Autowired
    private ServiceRepositiroLRP serviceRepositiroLRP;
    @Autowired
    private RepositoryLineaRegistroProducto repositoryLineaRegistroProducto;


    @GetMapping("/linea-registro-transacion-producto")
    public List<LineaRegistroTransaccionProductoDTO>getAllLis(){
        return repositoryLineaRegistroProducto.findAllByDTO();
    }

}
