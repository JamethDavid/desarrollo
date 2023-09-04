package com.example.desrrollo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "Variables")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Builder
public class Variable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idvariable;
    private String nombre;
    private String abreviatura;
    private String aplicacion;
    private BigDecimal valor;
    



}
