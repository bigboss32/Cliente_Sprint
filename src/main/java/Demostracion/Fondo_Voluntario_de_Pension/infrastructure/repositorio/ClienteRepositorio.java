package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.ClienteEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.TransaccionEntity;

public interface ClienteRepositorio extends JpaRepository<ClienteEntity, String> {

    
} 