package com.example.desrrollo.Repository;

import com.example.desrrollo.Api.ProductoLineaProductoDTO;
import com.example.desrrollo.Api.RegistroTransaccionInformeClienteDTO;
import com.example.desrrollo.Api.RegistroTransaccionInformeEntradaInventarioDTO;
import com.example.desrrollo.Api.RegistroTransaccionInformeSalidaInventarioDTO;
import com.example.desrrollo.Entity.RegistroTransaccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


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
    FROM registro_transaccion rt
    JOIN rt.persona p on rt.tercero = p.idPersona
    where rt.tercero = :idPersona
    and rt.descripcion like '%'
    and rt.fecha>= :fechaInicio
    and rt.fecha<= :fechaFinal
    ORDER BY rt.fecha

""")
    List<RegistroTransaccionInformeClienteDTO>findByFechaAndPersona(LocalDateTime fechaInicial, LocalDateTime fechaFinal,String idPersona );
    @Query("""
    SELECT NEW com.example.desrrollo.Query.RefenciaClienteDto(p.idPersona , p.nombre)
    FROM persona p
    WHERE p.rol = com.example.desrrollo.Entity.Persona.Rol.Cliente
    order by p.nombre
    
""")
    List<RegistroTransaccionInformeClienteDTO>findAllCliente();
}