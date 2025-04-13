package Demostracion.Fondo_Voluntario_de_Pension.application.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import Demostracion.Fondo_Voluntario_de_Pension.application.HistorialService;
import Demostracion.Fondo_Voluntario_de_Pension.application.puerto.ClientePuerto;
import Demostracion.Fondo_Voluntario_de_Pension.application.puerto.TransaccionPuerto;
import Demostracion.Fondo_Voluntario_de_Pension.application.servicio.Mapper.TransaccionMapper;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out.TransaccionResponse;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.ClienteEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.TransaccionEntity;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class HistorialServicesImpl implements HistorialService {
     private final TransaccionPuerto transaccionPuerto;
     private final ClientePuerto clientePuerto;
     private final TransaccionMapper transaccionMapper;
    @Override
    public  List<TransaccionResponse> obtenerHistorial(String clienteId) {
        ClienteEntity cliente=clientePuerto.encontrarCliente(clienteId);
        List<TransaccionEntity> historial= transaccionPuerto.historial(cliente);
        return historial.stream().map(transaccionMapper::toResponse).toList();
    }

}
