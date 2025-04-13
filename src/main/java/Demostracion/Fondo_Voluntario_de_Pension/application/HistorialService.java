package Demostracion.Fondo_Voluntario_de_Pension.application;

import java.util.List;

import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out.TransaccionDTO;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out.TransaccionResponse;

public interface HistorialService {
    List<TransaccionResponse>  obtenerHistorial(String clienteId);
   
}
