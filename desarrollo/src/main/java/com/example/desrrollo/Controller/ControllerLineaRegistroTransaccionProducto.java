package com.example.desrrollo.Controller;

import com.example.desrrollo.Api.LineaRegistroTransaccionProductoDTO;
import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import com.example.desrrollo.Services.LineaRegistroTransaccionProductoImpl;
import com.example.desrrollo.Services.ServiceRepositiroLRP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerLineaRegistroTransaccionProducto {
    @Autowired
    private LineaRegistroTransaccionProductoImpl lineaRegistroTransaccionProductoImpl;
    @Autowired
    private ServiceRepositiroLRP serviceRepositiroLRP;
    @Autowired
    private RepositoryLineaRegistroProducto repositoryLineaRegistroProducto;


    @GetMapping("/listaDTO")
    public List<LineaRegistroTransaccionProductoDTO>getAllLis(){
        return repositoryLineaRegistroProducto.findAllByDTO();
    }

}
