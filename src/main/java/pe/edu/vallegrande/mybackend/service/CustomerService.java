package pe.edu.vallegrande.mybackend.service;

import pe.edu.vallegrande.mybackend.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAll();

    Optional<Customer> findById(Integer id);

    List<Customer> findByEstado(String estado);

    Customer save(Customer customer);

    Customer update(Customer customer);

    void delete(Integer id);

    void restore(Integer id);
}
