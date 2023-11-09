package com.example.desrrollo.Repository;

import com.example.desrrollo.Entity.EmpresaC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEmpresaC extends JpaRepository<EmpresaC, String> {
    EmpresaC findByUsuario(String usuario);

}
