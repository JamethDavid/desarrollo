package com.example.desrrollo.Services;

import com.example.desrrollo.Api.ProductoNombreDTO;
import com.example.desrrollo.Entity.Producto;
import com.example.desrrollo.Repository.RepositoryLineaProducto;
import com.example.desrrollo.Repository.RepositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class serviceQuery  implements   IserviceQuery{
    @Autowired
    private RepositoryLineaProducto repositoryLineaProducto;
    @Override
    public List<ProductoNombreDTO> findAllByName() {
        return repositoryLineaProducto.findAllByNombre() ;
    }
}
