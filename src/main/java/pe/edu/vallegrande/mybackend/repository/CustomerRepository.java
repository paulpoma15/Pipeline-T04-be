package pe.edu.vallegrande.mybackend.repository;

import pe.edu.vallegrande.mybackend.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

    // Buscar por número de documento
    Mono<Customer> findByNroDocument(String nroDocument);

    // Buscar por estado (true = activo, false = inactivo)
    Flux<Customer> findByEstado(boolean estado);
}