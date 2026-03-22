package pe.edu.vallegrande.mybackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customer")
public class Customer {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String documentType;

    private String nroDocument;

    private String phone;

    private String email;

    private boolean estado; // true = activo, false = inactivo
}