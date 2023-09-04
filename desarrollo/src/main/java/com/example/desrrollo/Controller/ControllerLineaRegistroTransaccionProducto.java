package com.example.desrrollo.Controller;

import com.example.desrrollo.Api.ResponseLineaRegistroTransaccionProducto;
import com.example.desrrollo.Services.LineaRegistroTransaccionProductoImpl;
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

    @GetMapping("/lineaRegistroTransaccionProducto")
    public List<ResponseLineaRegistroTransaccionProducto>getAllLineaRegistroTransaccionProductoList(){
        return lineaRegistroTransaccionProductoImpl.getAllResponseLineaRegistroProducto();
    }

}
