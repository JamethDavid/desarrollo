package com.example.desrrollo.Repository;

import com.example.desrrollo.Api.KardexDTO;
import com.example.desrrollo.Entity.Kardex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryKardex extends JpaRepository<Kardex,Long> {



}
