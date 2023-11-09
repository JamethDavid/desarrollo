package com.example.desrrollo.Repository;

import com.example.desrrollo.Entity.EmpresaC;
import com.example.desrrollo.Query.EmpresaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryEmpresa extends JpaRepository<EmpresaC, Integer> {

}
