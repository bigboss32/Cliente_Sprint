package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.in;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SuscripcionRequest {
    private String clienteId;
    private String fondoId;
    private long monto;
}