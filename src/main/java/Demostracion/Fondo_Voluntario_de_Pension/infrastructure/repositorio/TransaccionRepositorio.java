package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.repositorio;


import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.ClienteEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.FondoEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.TransaccionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TransaccionRepositorio extends JpaRepository<TransaccionEntity, String> {
     Optional<TransaccionEntity> findFirstByClienteAndFondoAndTipoOrderByFechaDesc(ClienteEntity cliente, FondoEntity fondo, String tipo);
     Optional<TransaccionEntity> findFirstByClienteAndFondoOrderByFechaDesc(ClienteEntity cliente, FondoEntity fondo);
     List<TransaccionEntity> findByClienteOrderByFechaDesc(ClienteEntity cliente);

}
