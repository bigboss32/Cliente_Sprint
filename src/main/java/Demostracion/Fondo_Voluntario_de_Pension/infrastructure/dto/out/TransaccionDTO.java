package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class TransaccionDTO {
    private String id;
    private String nombreFondo;
    private String tipo;
    private Instant fecha;
    private long monto;
}
