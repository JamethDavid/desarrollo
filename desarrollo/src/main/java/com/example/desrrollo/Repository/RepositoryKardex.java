package com.example.desrrollo.Repository;

import com.example.desrrollo.Api.KardexDTO;
import com.example.desrrollo.Entity.Kardex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryKardex extends JpaRepository<Kardex,Long> {
    @Query("""
    SELECT NEW com.example.desrrollo.Api.KardexDTO(k.idKardex,k.fecha,k.detalle,k.valorUnitario,
    k.cantidadEntrada,k.valorEntrada,k.valorSaldo,
    k.cantidadSaldo,k.valorSaldo,k.ubica,k.documento)
    FROM kardex k where k.producto.idProducto =:idVendedor
""")
    List<KardexDTO>findAllByIdKardex(String idVendedor);


}
