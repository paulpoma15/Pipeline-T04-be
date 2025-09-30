package pe.edu.vallegrande.mybackend.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "customer") // nombre exacto .de la tabla en SQL Server
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "document_type", nullable = false)
    private String documentType;

    @Column(name = "nro_document", nullable = false, unique = true)
    private String nroDocument;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(length = 1, nullable = false)
    private String estado;
}
