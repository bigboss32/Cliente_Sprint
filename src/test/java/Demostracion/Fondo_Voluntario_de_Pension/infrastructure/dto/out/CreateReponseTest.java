package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;

public class CreateReponseTest {

    @Test
    public void testGettersAndSetters() {
        // Crear una instancia de CreateReponse
        CreateReponse response = new CreateReponse();

        // Establecer un valor
        String suscripcion = "suscripcion123";
        response.setSuscripción(suscripcion);

        // Verificar que el valor se haya establecido correctamente usando los getters
        Assertions.assertThat(response.getSuscripción()).isEqualTo(suscripcion);
    }

    @Test
    public void testToString() {
        // Crear una instancia de CreateReponse con un valor
        CreateReponse response = new CreateReponse();
        response.setSuscripción("suscripcion123");

        // Verificar el resultado del método toString
        String expectedToString = "CreateReponse(suscripción=suscripcion123)";
        Assertions.assertThat(response.toString()).isEqualTo(expectedToString);
    }

    @Test
    public void testDefaultConstructor() {
        // Crear una instancia con el constructor por defecto
        CreateReponse response = new CreateReponse();

        // Verificar que el valor por defecto de suscripción sea null
        assertNull(response.getSuscripción());
    }
}
