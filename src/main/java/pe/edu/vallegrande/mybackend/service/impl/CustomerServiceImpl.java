package pe.edu.vallegrande.mybackend.service.impl;

import pe.edu.vallegrande.mybackend.model.Customer;
import pe.edu.vallegrande.mybackend.repository.CustomerRepository;
import pe.edu.vallegrande.mybackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findByEstado(String estado) {
        return customerRepository.findByEstado(estado);
    }

    @Override
    public Customer save(Customer customer) {
        customer.setEstado("A"); // siempre se crea como Activo
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        customerRepository.findById(id).ifPresent(c -> {
            c.setEstado("I");
            customerRepository.save(c);
        });
    }

    @Override
    public void restore(Integer id) {
        customerRepository.findById(id).ifPresent(c -> {
            c.setEstado("A");
            customerRepository.save(c);
        });
    }
}
