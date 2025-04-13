package Demostracion.Fondo_Voluntario_de_Pension.application.puerto;

import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.ClienteEntity;

public interface ClientePuerto {
   ClienteEntity encontrarCliente(String id);
   void actualizar( ClienteEntity cliente);

}
