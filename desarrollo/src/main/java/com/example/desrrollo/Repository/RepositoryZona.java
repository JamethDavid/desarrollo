package com.example.desrrollo.Repository;

import com.example.desrrollo.Entity.Zona;
import com.example.desrrollo.Query.ProductoNombreDTO;
import com.example.desrrollo.Query.ReferenciaZonaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositoryZona extends JpaRepository<Zona , Integer> {
    @Query("""
    SELECT NEW com.example.desrrollo.Query.ReferenciaZonaDTO(z.nombre)
    FROM Zona z

""")
    List<ReferenciaZonaDTO> findAllByNombre();
}
