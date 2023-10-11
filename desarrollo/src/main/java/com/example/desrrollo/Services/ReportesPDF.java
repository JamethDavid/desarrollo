package com.example.desrrollo.Services;

import com.example.desrrollo.Api.ProductoLineaProductoDTO;
import com.example.desrrollo.Repository.RepositoryLineaRegistroProducto;
import com.example.desrrollo.Repository.RepositoryProducto;
import com.example.desrrollo.Repository.RepositoryRegistroTransacion;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReportesPDF  implements  IReporteService{
    @Autowired
    private RepositoryProducto repositoryProducto;
    @Autowired
    private RepositoryLineaRegistroProducto repositoryLineaRegistroProducto;
    @Autowired
    private ReporteService reporteService;
    @Autowired
    private RepositoryRegistroTransacion repositoryRegistroTransacion;


    public byte[] exportToListaExistentePdf() throws JRException, FileNotFoundException {
        return reporteService.exportToListaExistentePdf(repositoryProducto.findAllProductoUnidadMedidaListaExistenteDTO());
    }

    @Override
    public byte[] exportToInventarioValorizadoPdf() throws JRException, FileNotFoundException {
        return reporteService.exportToInventarioValorizadoPdf(repositoryProducto.findAllProductoUnidadMedidaInventarioValorizadoDTO());
    }

    @Override
    public byte[] exportToLineaProductoPdf(String nombre) throws JRException, FileNotFoundException {
        return reporteService.exportToLineaProductoPdf(repositoryProducto.findAllByNombre(nombre),nombre);
    }

    @Override
    public byte[] exportToEntradaInventarioPdf(LocalDateTime fechaInicio, LocalDateTime fechaFinal) throws JRException, FileNotFoundException {
        return reporteService.exportToEntradaInventarioPdf(repositoryRegistroTransacion.findAllByFechaEntarda(fechaInicio,fechaFinal),fechaInicio,fechaFinal);
    }

    @Override
    public byte[] exportPdf() throws JRException, FileNotFoundException {
        return reporteService.exportToPdf(repositoryLineaRegistroProducto.findAllByDTO());
    }

    @Override
    public byte[] exportToListaPrecioPdf() throws JRException, FileNotFoundException {
        return reporteService.exportToListaPrecioPdf(repositoryProducto.findAllProductoUnidadMedidaListaPrecioDTO());
    }
}
