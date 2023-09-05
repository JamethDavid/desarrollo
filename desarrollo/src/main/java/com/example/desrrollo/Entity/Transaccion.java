package com.example.desrrollo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "transaccion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Builder
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Long idTransaccion;

}
