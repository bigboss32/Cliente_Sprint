package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.NotificacionPreferenciaEntity;

public interface NotificacionPreferenciaRepositorio extends JpaRepository<NotificacionPreferenciaEntity, String> {}
