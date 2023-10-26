package com.example.desrrollo.Repository;

import com.example.desrrollo.Api.*;
import com.example.desrrollo.Entity.RegistroTransaccion;

import com.example.desrrollo.Query.ReferenciaClienteDto;
import com.example.desrrollo.Query.ReferenciaZonaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Jpa21Utils;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Repository

public interface RepositoryRegistroTransacion extends JpaRepository<RegistroTransaccion,String> {
    @Query("""
    SELECT NEW com.example.desrrollo.Api.RegistroTransaccionInformeSalidaInventarioDTO(rt.consecutivoGravado,rt.fecha,rt.total)
    FROM registro_transaccion rt
    where rt.consecutivoGravado like '%'
    and rt.fecha>=:fechaInicial and rt.fecha<=:fechaFinal
    ORDER BY rt.fecha

""")
    List<RegistroTransaccionInformeSalidaInventarioDTO>findAllByFechaSalida(LocalDateTime fechaInicial, LocalDateTime fechaFinal );
    @Query("""
    SELECT NEW com.example.desrrollo.Api.RegistroTransaccionInformeEntradaInventarioDTO(rt.consecutivoGravado,rt.fecha,rt.total)
    FROM registro_transaccion rt
    where rt.consecutivoGravado like '%'
    and rt.fecha>=:fechaInicial and rt.fecha<=:fechaFinal
    ORDER BY rt.fecha

""")
    List<RegistroTransaccionInformeEntradaInventarioDTO>findAllByFechaEntarda(LocalDateTime fechaInicial, LocalDateTime fechaFinal );

    @Query("""
    SELECT NEW com.example.desrrollo.Api.RegistroTransaccionInformeClienteDTO(rt.consecutivoGravado,p.nombre,rt.fecha,rt.descripcion,rt.subtotal,rt.total,rt.fechaVencimiento)
    FROM registro_transaccion rt ,persona  p
    where rt.tercero = p.idPersona
    and rt.tercero = :idPersona
    and rt.descripcion like 'VENTAS%'
    and rt.fecha >= :fechaInicial
    and rt.fecha <= :fechaFinal
    ORDER BY rt.fecha

""")
    List<RegistroTransaccionInformeClienteDTO>findByFechaAndPersona(LocalDateTime fechaInicial, LocalDateTime fechaFinal,String idPersona);
    @Query("""
    SELECT NEW com.example.desrrollo.Query.ReferenciaClienteDto(p.idPersona , p.nombre)
    FROM persona p
    WHERE p.rol = 'Cliente'
    order by p.nombre
    
""")
    List<ReferenciaClienteDto>findAllCliente();

    @Query("""
    SELECT NEW com.example.desrrollo.Api.ZonaReporteVentaDTO(z.nombre, rt.descripcion, rt.consecutivoGravado, rt.tercero, p.nombre, rt.total)
    FROM registro_transaccion rt ,persona p, zona z
    where rt.tipo like 'V%'
    and rt.tercero = p.idPersona
    and p.zona.idZona=z.idZona
    and z.nombre = :nombre
    and rt.anulada= 0
    order by p.nombre, rt.consecutivoGravado
""")
    List<ZonaReporteVentaDTO>findAllZona(String nombre);
    @Query("""
    SELECT NEW com.example.desrrollo.Api.ZonaReporteVentaFechaDTO(z.nombre, rt.descripcion,p.nombre,rt.total,rt.fecha, rt.consecutivoGravado)
    FROM registro_transaccion rt ,persona p, zona z
    where rt.tipo like 'V%'
    and rt.tercero = p.idPersona
    and p.zona.idZona=z.idZona
    and rt.anulada= 0
    order by rt.fecha
""")
    List<ZonaReporteVentaFechaDTO>findAllZonaFecha();

    @Query("""
    SELECT NEW com.example.desrrollo.Api.ReportePedidoPendienteDTO(rt.consecutivoGravado,p.nombre,rt.fecha,rt.subtotal,rt.total,rt.observacion)
    FROM registro_transaccion rt ,persona p
    where rt.tipo ='PE'
    and rt.estado ='P'
    and p.idPersona = rt.tercero
    order by p.nombre
""")
    List<ReportePedidoPendienteDTO>findAllReportePedidoPendiente();
}