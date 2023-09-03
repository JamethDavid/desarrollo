package com.example.desrrollo.Repository;

import com.example.desrrollo.Entity.RegistroTransaccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Jpa21Utils;

import java.util.Date;
import java.util.List;


public interface RepositoryRegistroTransacion extends JpaRepository<RegistroTransaccion,String> {
@Query(value = "select rt.fecha,rt.persona from registro_transaccion rt " ,nativeQuery = true)
    List<Object[]>fecha();

}