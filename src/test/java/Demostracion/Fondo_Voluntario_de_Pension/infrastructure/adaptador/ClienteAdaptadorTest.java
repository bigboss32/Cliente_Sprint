package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.adaptador;

import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.ClienteEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.repositorio.ClienteRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)  
class ClienteAdaptadorTest {

    @Mock
    private ClienteRepositorio clienteRepositorio; 

    @InjectMocks
    private ClienteAdaptador clienteAdaptador;  

    private ClienteEntity cliente;

    @BeforeEach
    public void setUp() {
        cliente = new ClienteEntity();
        cliente.setId(123l);
        cliente.setNombre("Juan Pérez");
    }

    @Test
    void testEncontrarCliente_ClienteExistente() {
        when(clienteRepositorio.findById("123")).thenReturn(java.util.Optional.of(cliente));
        ClienteEntity result = clienteAdaptador.encontrarCliente("123");
        assertEquals(cliente, result);
        verify(clienteRepositorio, times(1)).findById("123");
    }

    @Test
    void testEncontrarCliente_ClienteNoExistente() {

        when(clienteRepositorio.findById("123")).thenReturn(java.util.Optional.empty());
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            clienteAdaptador.encontrarCliente("123");
        });
        assertEquals("Cliente no encontrado", exception.getReason());
        verify(clienteRepositorio, times(1)).findById("123");
    }

    @Test
    void testActualizar() {
    
        when(clienteRepositorio.save(cliente)).thenReturn(cliente);
        clienteAdaptador.actualizar(cliente);
        verify(clienteRepositorio, times(1)).save(cliente);
    }
}
