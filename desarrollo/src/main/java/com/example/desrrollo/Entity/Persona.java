package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "registro_transaccion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Builder

public class Persona {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column
    private String idPersona;
    @Column
    private  String nombre;

}
