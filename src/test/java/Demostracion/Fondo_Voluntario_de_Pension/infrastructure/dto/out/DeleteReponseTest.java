package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;

public class DeleteReponseTest {

    @Test
    public void testGettersAndSetters() {
        // Crear una instancia de DeleteReponse
        DeleteReponse response = new DeleteReponse();

        // Establecer un valor
        String eliminado = "fondo123";
        response.setEliminado(eliminado);

        // Verificar que el valor se haya establecido correctamente usando los getters
        Assertions.assertThat(response.getEliminado()).isEqualTo(eliminado);
    }

    @Test
    public void testToString() {
        // Crear una instancia de DeleteReponse con un valor
        DeleteReponse response = new DeleteReponse();
        response.setEliminado("fondo123");

        // Verificar el resultado del método toString
        String expectedToString = "DeleteReponse(eliminado=fondo123)";
        Assertions.assertThat(response.toString()).isEqualTo(expectedToString);
    }

    @Test
    public void testDefaultConstructor() {
        // Crear una instancia con el constructor por defecto
        DeleteReponse response = new DeleteReponse();

        // Verificar que el valor por defecto de eliminado sea null
        assertNull(response.getEliminado());
    }
}
