package pe.edu.vallegrande.mybackend.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.edu.vallegrande.mybackend.model.Payment;
import reactor.core.publisher.Flux;

public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {

    Flux<Payment> findByActiveTrue();
}