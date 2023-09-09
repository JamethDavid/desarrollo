package com.example.desrrollo.Services;

import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import org.springframework.stereotype.Service;

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
   /* public  List<LineaRegistroTransaccionProductoDTO> getListaConsulta(){
        return repositoryLineaRegistroProducto.findAllByDTO();
    }

    */
}