package com.example.desrrollo.Api;

import com.example.desrrollo.Entity.RegistroTransaccion;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
public class LineaRegistroTransaccionProductoDTO {

    Double cantidad;
    BigDecimal valorBruto;


}
