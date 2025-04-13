package Demostracion.Fondo_Voluntario_de_Pension.application.puerto;

import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.FondoEntity;

public interface FondoPuerto {
    FondoEntity encontrarFondo(String idFondo);

    
} 
