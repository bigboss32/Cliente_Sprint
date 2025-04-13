package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;

public class TransaccionDTOTest {

    @Test
    public void testGettersAndSetters() {
        TransaccionDTO transaccion = new TransaccionDTO();
        String id = "TXN123";
        String nombreFondo = "Fondo A";
        String tipo = "Depósito";
        Instant fecha = Instant.now();
        long monto = 5000;
        transaccion.setId(id);
        transaccion.setNombreFondo(nombreFondo);
        transaccion.setTipo(tipo);
        transaccion.setFecha(fecha);
        transaccion.setMonto(monto);
        Assertions.assertThat(transaccion.getId()).isEqualTo(id);
        Assertions.assertThat(transaccion.getNombreFondo()).isEqualTo(nombreFondo);
        Assertions.assertThat(transaccion.getTipo()).isEqualTo(tipo);
        Assertions.assertThat(transaccion.getFecha()).isEqualTo(fecha);
        Assertions.assertThat(transaccion.getMonto()).isEqualTo(monto);
    }

    @Test
    public void testDefaultConstructor() {
        TransaccionDTO transaccion = new TransaccionDTO();
        assertNull(transaccion.getId());
        assertNull(transaccion.getNombreFondo());
        assertNull(transaccion.getTipo());
        assertNull(transaccion.getFecha());
        assertEquals(0, transaccion.getMonto());
    }


}
