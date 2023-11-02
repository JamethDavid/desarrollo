package com.example.desrrollo.Repository;

import com.example.desrrollo.Entity.Empresa;
import com.example.desrrollo.Query.EmpresaDTO;
import com.example.desrrollo.Query.KardexReferenciaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryEmpresa extends JpaRepository<Empresa , Integer> {
    @Query("""
    SELECT NEW com.example.desrrollo.Query.EmpresaDTO(e.idEmpresa ,e.usuario,e.nit,e.nombreEmpresa)
    FROM empresa e
""")
    List<EmpresaDTO> findAllEmpresa();

}
