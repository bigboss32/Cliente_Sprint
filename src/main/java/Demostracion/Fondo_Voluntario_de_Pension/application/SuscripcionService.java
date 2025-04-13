package Demostracion.Fondo_Voluntario_de_Pension.application;

import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.in.CancelarSuscripcionRequest;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.in.SuscripcionRequest;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out.CreateReponse;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out.DeleteReponse;

public interface SuscripcionService {
    CreateReponse suscribirse(SuscripcionRequest request);
    DeleteReponse cancelarSuscripcion(CancelarSuscripcionRequest request);

}
