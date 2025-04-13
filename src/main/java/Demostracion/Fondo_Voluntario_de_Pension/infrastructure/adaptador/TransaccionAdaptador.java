package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.adaptador;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import Demostracion.Fondo_Voluntario_de_Pension.application.puerto.TransaccionPuerto;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.ClienteEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.FondoEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity.TransaccionEntity;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.repositorio.TransaccionRepositorio;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class TransaccionAdaptador implements TransaccionPuerto {
    private final TransaccionRepositorio transaccionRepository;
    @Override
    public Long registrar(ClienteEntity cliente, FondoEntity fondo, Long monto) {
        Optional<TransaccionEntity> existeSuscripcion =
                transaccionRepository.findFirstByClienteAndFondoOrderByFechaDesc(cliente, fondo);
    
        if (existeSuscripcion.isPresent()) {
            TransaccionEntity ultimaTransaccion = existeSuscripcion.get();
    
            if (ultimaTransaccion.getTipo().equalsIgnoreCase("CANCELACION")) {
                ultimaTransaccion.setTipo("APERTURA");
                ultimaTransaccion.setFecha(Instant.now()); // actualizamos la fecha también
                ultimaTransaccion.setMontoAportado(monto); // si querés reflejar el nuevo monto
                transaccionRepository.save(ultimaTransaccion);
                return ultimaTransaccion.getId();
            } else {
               
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No existe suscripción activa para cancelar.");
            }
        }

        TransaccionEntity nuevaTransaccion = new TransaccionEntity();
        nuevaTransaccion.setCliente(cliente);
        nuevaTransaccion.setFondo(fondo);
        nuevaTransaccion.setTipo("APERTURA");
        nuevaTransaccion.setFecha(Instant.now());
        nuevaTransaccion.setMontoAportado(monto);
        transaccionRepository.save(nuevaTransaccion);
    
        return nuevaTransaccion.getId();
    }
    @Override
    public Optional<TransaccionEntity> existeSuscripcion(ClienteEntity cliente, FondoEntity fondo, String tipo) {
        Optional<TransaccionEntity>  existeSuscripcion =transaccionRepository.findFirstByClienteAndFondoAndTipoOrderByFechaDesc(cliente,fondo,tipo);
        if (!existeSuscripcion.isPresent()) {
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No existe suscripción activa para cancelar.");
        }
        return existeSuscripcion;
    }
    @Override
    public Long cancelar(TransaccionEntity transaccionEntity) {
        transaccionEntity.setTipo("CANCELACION");
        transaccionRepository.save(transaccionEntity);
        return transaccionEntity.getId();
    }
    @Override
    public List<TransaccionEntity> historial(ClienteEntity cliente) {

        List<TransaccionEntity> a=transaccionRepository.findByClienteOrderByFechaDesc(cliente);
        return a;
    }

}
