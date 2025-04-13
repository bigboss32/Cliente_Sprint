package Demostracion.Fondo_Voluntario_de_Pension.application.servicio.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.TransaccionEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out.TransaccionResponse;

@Mapper(componentModel = "spring")
public interface TransaccionMapper {

    TransaccionMapper INSTANCE = Mappers.getMapper(TransaccionMapper.class);

    @Mapping(source = "fondo.id", target = "fondoId")
    @Mapping(source = "fondo.nombre", target = "nombre")
    TransaccionResponse toResponse(TransaccionEntity entity);
}