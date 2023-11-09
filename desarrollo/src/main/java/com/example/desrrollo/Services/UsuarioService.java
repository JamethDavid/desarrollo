package com.example.desrrollo.Services;

import com.example.desrrollo.Entity.Usuario;
import com.example.desrrollo.Repository.ReporsitoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private ReporsitoryUser reporsitoryUser;

    public List<Usuario> findAll() {
        return (List<Usuario>) this.reporsitoryUser.findAll();
    }
    public Usuario findByUsuario(String userName) {
        return this.reporsitoryUser.findByUsuario(userName);
    }
    public int validarFecha(String fecha) {
        int dias = 0;
        dias = reporsitoryUser.dias(fecha);
        return dias;
    }
}
