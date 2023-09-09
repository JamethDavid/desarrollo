package com.example.desrrollo.Services;

import com.example.desrrollo.Api.LineaRegistroTransaccionProductoDTO;
import com.example.desrrollo.Entity.LineaRegistroTransaccionProducto;
import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRepositiroLRP {
    private final RepositoryLineaRegistroProducto repositoryLineaRegistroProducto;

    public ServiceRepositiroLRP(RepositoryLineaRegistroProducto repositoryLineaRegistroProducto) {
        this.repositoryLineaRegistroProducto = repositoryLineaRegistroProducto;

    }


  /*  public List<LineaRegistroTransaccionProductoDTO> getListaConsulta() {
        return repositoryLineaRegistroProducto.findAllLineaRegistroTransaccion();

    }


   */
    public  List<LineaRegistroTransaccionProductoDTO> getListaConsulta(){
        return repositoryLineaRegistroProducto.find();
    }
}