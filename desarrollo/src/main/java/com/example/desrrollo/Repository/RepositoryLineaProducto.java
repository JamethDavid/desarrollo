package com.example.desrrollo.Repository;

import com.example.desrrollo.Query.ProductoNombreDTO;
import com.example.desrrollo.Entity.LineaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryLineaProducto extends JpaRepository<LineaProducto ,Long>{
    @Query("""
    SELECT NEW com.example.desrrollo.Query.ProductoNombreDTO(lp.nombre)
    FROM linea_producto lp

""")
    List<ProductoNombreDTO> findAllByNombre();

}
