package com.example.desrrollo.Repository;

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
    where rt.consecutivoGravado like 'SI%'
    and rt.fecha>=:fechaInicial and rt.fecha<=:fechaFinal
    ORDER BY rt.fecha

""")
    List<RegistroTransaccionInformeSalidaInventarioDTO>findAllByFechaSalida(LocalDateTime fechaInicial, LocalDateTime fechaFinal );
    @Query("""
    SELECT NEW com.example.desrrollo.Api.RegistroTransaccionInformeEntradaInventarioDTO(rt.consecutivoGravado,rt.fecha,rt.total)
    FROM registro_transaccion rt
    where rt.consecutivoGravado like 'EN%'
    and rt.fecha>=:fechaInicial and rt.fecha<=:fechaFinal
    ORDER BY rt.fecha

""")
    List<RegistroTransaccionInformeEntradaInventarioDTO>findAllByFechaEntarda(LocalDateTime fechaInicial, LocalDateTime fechaFinal );
}