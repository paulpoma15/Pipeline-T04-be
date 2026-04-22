package pe.edu.vallegrande.mybackend.service;

import pe.edu.vallegrande.mybackend.model.Payment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PaymentService {

    Flux<Payment> findAll();

    Mono<Payment> findById(String id);

    Mono<Payment> create(Payment payment);

    Mono<Payment> update(String id, Payment payment);

    Mono<Void> delete(String id);

    Mono<Payment> restore(String id);
}