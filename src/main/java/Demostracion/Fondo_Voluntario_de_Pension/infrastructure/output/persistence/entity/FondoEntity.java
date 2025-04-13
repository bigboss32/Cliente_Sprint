package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "fondos")
public class FondoEntity {

    @Id
    private String id;

    private String nombre;

    @Column(name = "monto_minimo")
    private long montoMinimo;

    private String categoria;

    @OneToMany(mappedBy = "fondo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransaccionEntity> transacciones;

    // Getters y Setters
}
