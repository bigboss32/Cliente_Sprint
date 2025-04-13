package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class TransaccionResponse {
    private String fondoId;
    private String tipo;
    private String nombre;
    private Instant fecha;
}