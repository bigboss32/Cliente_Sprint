package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "transacciones")
public class TransaccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "fondo_id", nullable = false)
    private FondoEntity fondo;

    private String tipo; // "APERTURA" o "CANCELACION"

    private Instant fecha;

    private Long montoAportado;

    // Getters y Setters
}
