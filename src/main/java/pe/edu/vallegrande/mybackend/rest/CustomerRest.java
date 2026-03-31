package pe.edu.vallegrande.mybackend.rest;

import pe.edu.vallegrande.mybackend.model.Customer;
import pe.edu.vallegrande.mybackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/customer")
public class CustomerRest {

    private final CustomerService customerService;

    @Autowired
    public CustomerRest(CustomerService customerService) {
        this.customerService = customerService;
    }

    // LISTAR TODOS LOS CLIENTES
    @GetMapping
    public Flux<Customer> findAll() {
        return customerService.findAll();
    }

    // BUSCAR CLIENTE POR ID
    @GetMapping("/{id}")
    public Mono<Customer> findById(@PathVariable String id) {
        return customerService.findById(id);
    }

    // LISTAR CLIENTES POR ESTADO
    // true = activos
    // false = eliminados
    @GetMapping("/state/{estado}")
    public Flux<Customer> findByEstado(@PathVariable boolean estado) {
        return customerService.findByEstado(estado);
    }

    // CREAR CLIENTE
    @PostMapping
    public Mono<Customer> save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    // ACTUALIZAR CLIENTE
    @PutMapping("/{id}")
    public Mono<Customer> update(@PathVariable String id,
                                 @RequestBody Customer customer) {
        return customerService.update(id, customer);
    }

    // ELIMINACIÓN LÓGICA
    @PatchMapping("/delete/{id}")
    public Mono<Customer> delete(@PathVariable String id) {
        return customerService.delete(id);
    }

    // RESTAURAR CLIENTE ELIMINADO
    @PatchMapping("/restore/{id}")
    public Mono<Customer> restore(@PathVariable String id) {
        return customerService.restore(id);
    }
}