package pe.edu.vallegrande.mybackend.rest;

import pe.edu.vallegrande.mybackend.model.Customer;
import pe.edu.vallegrande.mybackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/customer")   // http://localhost:8086/v1/api/customer
public class CustomerRest {

    private final CustomerService customerService;

    @Autowired
    public CustomerRest(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Listar todos
    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Optional<Customer> findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }

    // Buscar por estado
    @GetMapping("/state/{estado}")
    public List<Customer> findByEstado(@PathVariable String estado) {
        return customerService.findByEstado(estado);
    }

    // Crear
    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    // Actualizar
    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    // Eliminar (cambia estado a "I")
    @PatchMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        customerService.delete(id);
    }

    // Restaurar (cambia estado a "A")
    @PatchMapping("/restore/{id}")
    public void restore(@PathVariable Integer id) {
        customerService.restore(id);
    }
}
