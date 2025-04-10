package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "disponibilidad")
public class DisponibilidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id")  
    private SucursalEntity sucursal;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private ProductoEntity  producto;

    @Column(nullable = false)
    private String estado;


}
