package Demostracion.Fondo_Voluntario_de_Pension.application.puerto;

import java.util.List;
import java.util.Optional;

import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.ClienteEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.FondoEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.TransaccionEntity;

public interface TransaccionPuerto {
    Long registrar(ClienteEntity cliente,FondoEntity fondo,Long monto);
    Long cancelar(TransaccionEntity transaccionEntity);
    Optional<TransaccionEntity> existeSuscripcion(ClienteEntity cliente, FondoEntity fondo, String tipo);
    List<TransaccionEntity> historial(ClienteEntity cliente);

}
