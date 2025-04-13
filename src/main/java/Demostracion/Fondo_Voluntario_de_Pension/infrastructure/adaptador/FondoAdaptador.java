package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.adaptador;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Demostracion.Fondo_Voluntario_de_Pension.application.puerto.FondoPuerto;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.FondoEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.repositorio.ClienteRepositorio;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.repositorio.FondoRepositorio;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class FondoAdaptador implements FondoPuerto {
    private final FondoRepositorio fondoRepositorio;
    @Override
    public FondoEntity encontrarFondo(String idFondo) {
       FondoEntity fondoEntity= fondoRepositorio.findById(idFondo).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fondo no encontrado"));
         return fondoEntity;
    }

}
