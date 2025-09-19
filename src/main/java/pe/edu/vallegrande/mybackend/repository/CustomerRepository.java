package pe.edu.vallegrande.mybackend.repository;

import pe.edu.vallegrande.mybackend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Buscar por número de documento
    Customer findByNroDocument(String nroDocument);

    // Buscar por estado
    List<Customer> findByEstado(String estado);
}
