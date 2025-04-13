package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.in;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancelarSuscripcionRequest {
    private String clienteId;
    private String fondoId;
}