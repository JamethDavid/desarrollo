package com.example.desrrollo.Services;
import com.example.desrrollo.Api.ZonaReporteVentaDTO;
import com.example.desrrollo.Query.KardexReferenciaDTO;
import com.example.desrrollo.Query.ProductoNombreDTO;
import com.example.desrrollo.Query.ReferenciaClienteDto;
import com.example.desrrollo.Query.ReferenciaZonaDTO;
import com.example.desrrollo.Repository.RepositoryLineaProducto;
import com.example.desrrollo.Repository.RepositoryProducto;
import com.example.desrrollo.Repository.RepositoryRegistroTransacion;
import com.example.desrrollo.Repository.RepositoryZona;
import com.example.desrrollo.util.CargarPropiedades;
import com.example.desrrollo.util.ConstanteCoach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class serviceQuery  implements   IserviceQuery{
    private Properties properties = null;
    public serviceQuery() {
        properties = CargarPropiedades.cargarPropiedades(ConstanteCoach.PROPERTIES_FILE, true);
        if(properties == null) {
            System.out.println("Problema al cargar las propiedades: " + ConstanteCoach.PROPERTIES_FILE);
        }
    }
    @Autowired
    private RepositoryProducto repositoryProducto;
    @Autowired
    private RepositoryLineaProducto repositoryLineaProducto;
    @Autowired
    private RepositoryRegistroTransacion repositoryRegistroTransacion;
    @Autowired
    private RepositoryZona repositoryZona;
    @Override
    public List<ProductoNombreDTO> findAllByName() {
        return repositoryLineaProducto.findAllByNombre() ;
    }
    @Override
    public List<KardexReferenciaDTO> findAllByNameKardexDtos(){
        return repositoryProducto.findAllByIVendedorKardex();
    }
    @Override
    public KardexReferenciaDTO findByIdVendedorKardex(String idproducto){
        return repositoryProducto.findByIdVendedorKardex(idproducto); }
    @Override
    public List<ReferenciaClienteDto> findAllCliente(){
        return repositoryRegistroTransacion.findAllCliente();
    }
    @Override
    public List<ReferenciaZonaDTO> findAllZona() {
        return repositoryZona.findAllByNombre();
    }

    @Override
    public List<ZonaReporteVentaDTO> findAllZonaReporteNombre(String nombre) {
        return repositoryRegistroTransacion.findAllZona(nombre);
    }


}
