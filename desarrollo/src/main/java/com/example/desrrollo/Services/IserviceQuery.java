package com.example.desrrollo.Services;

import com.example.desrrollo.Api.KardexDTO;
import com.example.desrrollo.Entity.Kardex;
import com.example.desrrollo.Entity.Producto;
import com.example.desrrollo.Query.KardexReferenciaDTO;
import com.example.desrrollo.Query.ProductoNombreDTO;

import java.util.List;

public interface IserviceQuery {
    List<ProductoNombreDTO>findAllByName();
    List<KardexReferenciaDTO>findAllByNameKardexDtos();
    KardexReferenciaDTO findByIdVendedorKardex(String idproducto);


}
