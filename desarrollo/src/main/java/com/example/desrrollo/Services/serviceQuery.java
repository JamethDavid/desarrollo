package com.example.desrrollo.Services;

import com.example.desrrollo.Api.KardexDTO;
import com.example.desrrollo.Query.KardexReferenciaDTO;
import com.example.desrrollo.Query.ProductoNombreDTO;
import com.example.desrrollo.Repository.RepositoryKardex;
import com.example.desrrollo.Repository.RepositoryLineaProducto;
import com.example.desrrollo.Repository.RepositoryProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class serviceQuery  implements   IserviceQuery{
    @Autowired
    private RepositoryProducto repositoryProducto;
    @Autowired
    private RepositoryLineaProducto repositoryLineaProducto;
    @Override
    public List<ProductoNombreDTO> findAllByName() {
        return repositoryLineaProducto.findAllByNombre() ;
    }
    @Override
    public List<KardexReferenciaDTO> findAllByNameKardexDtos() {
        return repositoryProducto.findAllByIVendedorKardex();
    }
}
