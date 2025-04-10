package Demostracion.Fondo_Voluntario_de_Pension.infrastructure.output.persistence.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "producto")
public class ProductoEntity  {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String tipoProducto;


}
