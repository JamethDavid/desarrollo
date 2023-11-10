package com.example.desrrollo.Services;

import com.example.desrrollo.Entity.EmpresaC;
import com.example.desrrollo.Repository.RepositoryEmpresaC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    @Autowired
    private RepositoryEmpresaC repositoryEmpresaC;
    public EmpresaC findByUsuario(String usuario) {
        return repositoryEmpresaC.findByUsuario(usuario);
    }

}
