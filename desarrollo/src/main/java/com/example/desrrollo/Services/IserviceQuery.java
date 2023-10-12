package com.example.desrrollo.Services;

import com.example.desrrollo.Api.KardexDTO;
import com.example.desrrollo.Query.KardexReferenciaDTO;
import com.example.desrrollo.Query.ProductoNombreDTO;

import java.util.List;

public interface IserviceQuery {
    List<ProductoNombreDTO>findAllByName();
    List<KardexReferenciaDTO>findAllByNameKardexDtos();


}
