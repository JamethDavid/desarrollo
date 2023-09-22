package com.example.desrrollo.Repository;

import com.example.desrrollo.Api.LineaRegistroTransaccionProductoDTO;
import com.example.desrrollo.Api.kardexDTO;
import com.example.desrrollo.Entity.Kardex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryKardex extends JpaRepository<Kardex,Long> {
    @Query("""
    SELECT NEW com.example.desrrollo.Api.kardexDTO(k.idKardex,k.fecha,k.detalle,k.valorUnitario,
    k.cantidadEntrada,k.valorEntrada,k.valorSaldo,
    k.cantidadSaldo,k.valorSaldo,k.ubica,k.detalle)
    FROM kardex k where k.producto =:idVendedor
""")
    List<kardexDTO>findAllByIdKardex(long idVendedor);
}
