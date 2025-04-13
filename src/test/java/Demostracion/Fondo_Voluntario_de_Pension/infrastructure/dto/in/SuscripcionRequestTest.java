package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.in;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;

public class SuscripcionRequestTest {

    @Test
    public void testGettersAndSetters() {

        SuscripcionRequest request = new SuscripcionRequest();
        String clienteId = "cliente123";
        String fondoId = "fondo456";
        long monto = 1000L;
        request.setClienteId(clienteId);
        request.setFondoId(fondoId);
        request.setMonto(monto);
        Assertions.assertThat(request.getClienteId()).isEqualTo(clienteId);
        Assertions.assertThat(request.getFondoId()).isEqualTo(fondoId);
        Assertions.assertThat(request.getMonto()).isEqualTo(monto);
    }

    @Test
    public void testDefaultConstructor() {
        SuscripcionRequest request = new SuscripcionRequest();
        assertNull(request.getClienteId());
        assertNull(request.getFondoId());
        assertEquals(0L, request.getMonto());
    }
}
