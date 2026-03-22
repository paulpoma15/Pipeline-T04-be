package pe.edu.vallegrande.mybackend.service;

import pe.edu.vallegrande.mybackend.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    // LISTAR TODOS
    Flux<Customer> findAll();

    // BUSCAR POR ID
    Mono<Customer> findById(String id);

    // BUSCAR POR ESTADO
    Flux<Customer> findByEstado(boolean estado);

    // CREAR
    Mono<Customer> save(Customer customer);

    // ACTUALIZAR
    Mono<Customer> update(String id, Customer customer);

    // ELIMINAR LOGICO
    Mono<Customer> delete(String id);

    // RESTAURAR
    Mono<Customer> restore(String id);
}