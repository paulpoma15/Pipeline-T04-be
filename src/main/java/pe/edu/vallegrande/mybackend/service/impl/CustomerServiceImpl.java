package pe.edu.vallegrande.mybackend.service.impl;

import pe.edu.vallegrande.mybackend.model.Customer;
import pe.edu.vallegrande.mybackend.repository.CustomerRepository;
import pe.edu.vallegrande.mybackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    
    // ✅ Inyección del repository
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 🛠️🔍 Implementación del método Listar Todos
    @Override
    public List<Customer> findAll() {
        log.info("Listando Datos: ");
        return customerRepository.findAll();
    }

    // 🛠️🔍 Implementación del método Listar por Estado
    @Override
    public List<Customer> findByState(String state) {
        log.info("Listando Datos por Estado: " + state);
        return customerRepository.findByState(state);
    }

    // 🛠️🔍 Implementación del método Listar por ID
    @Override
    public Optional<Customer> findById(Long id) {
        log.info("Listando Datos por ID: " + id);
        return customerRepository.findById(id);
    }

    // 🛠️✅ Implementación del método Registrar
    @Override
    public Customer save(Customer customer) {
        log.info("Registrondo Datos: " + customer.toString());
        customer.setState("A");
        return customerRepository.save(customer);
    }

    // 🛠️✏️ Implementación del método Actualizar
    @Override
    public Customer update(Customer customer) {
        log.info("Editando Datos: " + customer.toString());
        customer.setState("A");
        return customerRepository.save(customer);
    }

    // 🛠️❌ Implementación del método Eliminar (Cambio de Estado) por ID
    @Override
    public Customer delete(Long id) {
        log.info("Eliminando Datos: " + id);
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setState("I");
        return customerRepository.save(customer);
    }

    // 🛠️♻️ Implementación del método Restaurar (Cambio de Estado) por ID
    @Override
    public Customer restore(Long id) {
        log.info("Restaurando Datos: " + id);
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setState("A");
        return customerRepository.save(customer);
    }

}