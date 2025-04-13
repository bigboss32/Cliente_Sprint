package Demostracion.Fondo_Voluntario_de_Pension.application.servicio;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Demostracion.Fondo_Voluntario_de_Pension.application.SuscripcionService;
import Demostracion.Fondo_Voluntario_de_Pension.application.puerto.ClientePuerto;
import Demostracion.Fondo_Voluntario_de_Pension.application.puerto.FondoPuerto;
import Demostracion.Fondo_Voluntario_de_Pension.application.puerto.TransaccionPuerto;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.in.CancelarSuscripcionRequest;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.in.SuscripcionRequest;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out.CreateReponse;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out.DeleteReponse;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.ClienteEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.FondoEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.TransaccionEntity;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SuscripcionServiceImpl implements SuscripcionService {
        private final TransaccionPuerto transaccionPuerto;
        private final ClientePuerto clientePuerto;
        private final FondoPuerto fondoPuerto;

        @Override
        public CreateReponse suscribirse(SuscripcionRequest request) {
                ClienteEntity cliente = clientePuerto.encontrarCliente(request.getClienteId());
                FondoEntity fondo = fondoPuerto.encontrarFondo(request.getFondoId());

                if (request.getMonto() < fondo.getMontoMinimo()) {
       
                            throw new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                String.format("El monto no es suficiente el monto minimo es %s para el fondo %s", fondo.getMontoMinimo(),fondo.getNombre())
                            );
                }
                if (cliente.getSaldo() < request.getMonto()) {
                        throw new ResponseStatusException(
                                HttpStatus.BAD_REQUEST,
                                String.format("No tiene saldo disponible para vincularse al fondo %s", fondo.getNombre())
                            );
                }
                cliente.setSaldo(cliente.getSaldo() - request.getMonto());
                clientePuerto.actualizar(cliente);
                CreateReponse mesanje = new CreateReponse();
                mesanje.setSuscripción(""+transaccionPuerto.registrar(cliente, fondo,request.getMonto()));
                return mesanje ;
        }

        @Override
        public DeleteReponse cancelarSuscripcion(CancelarSuscripcionRequest request) {
                ClienteEntity cliente = clientePuerto.encontrarCliente(request.getClienteId());
                FondoEntity fondo = fondoPuerto.encontrarFondo(request.getFondoId());
                Optional<TransaccionEntity>  transaccionEntity= transaccionPuerto.existeSuscripcion(cliente, fondo, "APERTURA");
                cliente.setSaldo(cliente.getSaldo()+transaccionEntity.get().getMontoAportado());
                clientePuerto.actualizar(cliente);
                DeleteReponse mesanje = new DeleteReponse();
                mesanje.setEliminado(""+transaccionPuerto.cancelar(transaccionEntity.get()));
                return mesanje;

        }

}
