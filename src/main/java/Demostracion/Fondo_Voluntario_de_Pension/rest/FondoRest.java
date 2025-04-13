package Demostracion.Fondo_Voluntario_de_Pension.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import Demostracion.Fondo_Voluntario_de_Pension.application.HistorialService;
import Demostracion.Fondo_Voluntario_de_Pension.application.SuscripcionService;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.in.CancelarSuscripcionRequest;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.in.SuscripcionRequest;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out.CreateReponse;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out.DeleteReponse;
import Demostracion.Fondo_Voluntario_de_Pension.infrastructure.dto.out.TransaccionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class FondoRest {
    private final SuscripcionService suscripcionService;
    private final HistorialService historialService;

    @PostMapping("/suscribirse")
    public ResponseEntity<CreateReponse> suscribirse(@RequestBody @Valid SuscripcionRequest request) {
        return ResponseEntity.ok(suscripcionService.suscribirse(request));

    }

    @DeleteMapping("/suscribirse")
    public ResponseEntity<DeleteReponse> Eliminarsuscribirse(@RequestBody @Valid CancelarSuscripcionRequest request) {
        return ResponseEntity.ok(suscripcionService.cancelarSuscripcion(request));

    }

    @GetMapping("/suscribirse")
    public ResponseEntity<List<TransaccionResponse>> historial(@RequestParam String id) {
        List<TransaccionResponse> historial = historialService.obtenerHistorial(id);
        return ResponseEntity.ok(historial);
    }

}
