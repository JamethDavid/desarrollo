package com.example.desrrollo.Repository;

import com.example.desrrollo.Api.VariableDTO;
import com.example.desrrollo.Entity.Variable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryVariable extends JpaRepository<Variable , Long> {


    @Query("SELECT  V FROM  Variables  V")
    List<Variable>findAllBy();

    @Query("select new com.example.desrrollo.Api.VariableDTO(v.abreviatura,v.valor) from Variables v")
    List<VariableDTO> findAllByDTO();
}
