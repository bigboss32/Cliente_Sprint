package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.FondoEntity;

public interface FondoRepositorio extends JpaRepository<FondoEntity, String> {

    
} 
