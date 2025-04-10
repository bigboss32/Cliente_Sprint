package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity;

import java.time.LocalDate;
 
import jakarta.persistence.*;
@Entity
@Table(name = "visitan")
public class VisitanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id") 
    private SucursalEntity sucursal;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private ClienteEntity  cliente;
    @Column(nullable = false)
    private LocalDate fechaVisita;


}
