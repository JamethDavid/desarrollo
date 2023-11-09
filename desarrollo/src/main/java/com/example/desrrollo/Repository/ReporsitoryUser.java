package com.example.desrrollo.Repository;

import com.example.desrrollo.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReporsitoryUser extends JpaRepository<Usuario , String> {
    Usuario findByUsuario(String usuario);
    @Query(value = "SELECT DATEDIFF(:fecha,NOW()) as dia", nativeQuery = true)
    int dias(@Param("fecha") String fecha);
}
