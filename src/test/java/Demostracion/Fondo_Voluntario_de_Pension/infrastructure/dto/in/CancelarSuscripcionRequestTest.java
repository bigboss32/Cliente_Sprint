package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.in;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;

public class CancelarSuscripcionRequestTest {

    @Test
    public void testGettersAndSetters() {
        CancelarSuscripcionRequest request = new CancelarSuscripcionRequest();
        String clienteId = "cliente123";
        String fondoId = "fondo456";
        request.setClienteId(clienteId);
        request.setFondoId(fondoId);
        Assertions.assertThat(request.getClienteId()).isEqualTo(clienteId);
        Assertions.assertThat(request.getFondoId()).isEqualTo(fondoId);
    }

    @Test
    public void testDefaultConstructor() {
        CancelarSuscripcionRequest request = new CancelarSuscripcionRequest();
        assertNull(request.getClienteId());
        assertNull(request.getFondoId());
    }
}
