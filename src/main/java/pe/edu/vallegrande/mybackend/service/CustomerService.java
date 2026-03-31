package pe.edu.vallegrande.mybackend.service;

import pe.edu.vallegrande.mybackend.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    // LISTAR TODOS LOS CLIENTES
    Flux<Customer> findAll();

    // BUSCAR CLIENTE POR ID
    Mono<Customer> findById(String id);

    // LISTAR CLIENTES POR ESTADO
    // true = activos
    // false = eliminados
    Flux<Customer> findByEstado(boolean estado);

    // CREAR CLIENTE
    Mono<Customer> save(Customer customer);

    // ACTUALIZAR CLIENTE
    Mono<Customer> update(String id, Customer customer);

    // ELIMINACIÓN LÓGICA
    Mono<Customer> delete(String id);

    // RESTAURAR CLIENTE
    Mono<Customer> restore(String id);
}