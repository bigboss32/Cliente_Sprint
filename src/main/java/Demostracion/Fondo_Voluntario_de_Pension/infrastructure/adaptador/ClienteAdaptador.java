package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.adaptador;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Demostracion.Fondo_Voluntario_de_Pension.application.puerto.ClientePuerto;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.ClienteEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.repositorio.ClienteRepositorio;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ClienteAdaptador implements ClientePuerto {
    
    private final ClienteRepositorio clienteRepositorio;
    
    
@Override
public ClienteEntity encontrarCliente(String id) {
    ClienteEntity cliente = clienteRepositorio.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
    return cliente;
}


@Override
@Transactional
public void actualizar(ClienteEntity cliente) {
    clienteRepositorio.save(cliente);
}

}
