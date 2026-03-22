package pe.edu.vallegrande.mybackend.service.impl;

import pe.edu.vallegrande.mybackend.model.Customer;
import pe.edu.vallegrande.mybackend.repository.CustomerRepository;
import pe.edu.vallegrande.mybackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // LISTAR TODOS
    @Override
    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

    // BUSCAR POR ID
    @Override
    public Mono<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    // BUSCAR POR ESTADO
    @Override
    public Flux<Customer> findByEstado(boolean estado) {
        return customerRepository.findByEstado(estado);
    }

    // CREAR
    @Override
    public Mono<Customer> save(Customer customer) {
        customer.setEstado(true); // activo por defecto
        return customerRepository.save(customer);
    }

    // ACTUALIZAR
    @Override
    public Mono<Customer> update(String id, Customer customer) {
        return customerRepository.findById(id)
                .flatMap(c -> {
                    c.setFirstName(customer.getFirstName());
                    c.setLastName(customer.getLastName());
                    c.setDocumentType(customer.getDocumentType());
                    c.setNroDocument(customer.getNroDocument());
                    c.setPhone(customer.getPhone());
                    c.setEmail(customer.getEmail());
                    return customerRepository.save(c);
                });
    }

    // ELIMINAR LOGICO
    @Override
    public Mono<Customer> delete(String id) {
        return customerRepository.findById(id)
                .flatMap(c -> {
                    c.setEstado(false);
                    return customerRepository.save(c);
                });
    }

    // RESTAURAR
    @Override
    public Mono<Customer> restore(String id) {
        return customerRepository.findById(id)
                .flatMap(c -> {
                    c.setEstado(true);
                    return customerRepository.save(c);
                });
    }
}