package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "preferencias_notificacion")
public class NotificacionPreferenciaEntity {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    private String tipo; // "EMAIL" o "SMS"

    private String destino;

    // Getters y Setters
}