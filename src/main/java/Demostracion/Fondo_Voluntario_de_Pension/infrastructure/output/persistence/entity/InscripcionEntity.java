package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inscripcion")
public class InscripcionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

 
    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id")  // Nombre de la columna FK en esta tabla
    private ProductoEntity producto;

 
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private ClienteEntity cliente;
    @Column(nullable = false)
    private String estado;

   
}
