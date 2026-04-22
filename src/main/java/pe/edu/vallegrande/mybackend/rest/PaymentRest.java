package pe.edu.vallegrande.mybackend.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.mybackend.model.Payment;
import pe.edu.vallegrande.mybackend.service.PaymentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/api/payments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "Payment API", description = "Reactive CRUD with MongoDB")
public class PaymentRest {

    private final PaymentService service;

    @Operation(summary = "GET ALL", description = "List all active payments")
    @GetMapping
    public Flux<Payment> findAll() {
        return service.findAll();
    }

    @Operation(summary = "GET BY ID", description = "Get active payment by id")
    @GetMapping("/{id}")
    public Mono<Payment> findById(@PathVariable String id) {
        return service.findById(id);
    }

    @Operation(summary = "CREATE", description = "Create a payment with details")
    @PostMapping
    public Mono<Payment> create(@RequestBody Payment payment) {
        return service.create(payment);
    }

    @Operation(summary = "UPDATE", description = "Update payment by id")
    @PutMapping("/{id}")
    public Mono<Payment> update(@PathVariable String id, @RequestBody Payment payment) {
        return service.update(id, payment);
    }

    @Operation(summary = "DELETE", description = "Logical delete payment")
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }

    @Operation(summary = "RESTORE", description = "Restore logically deleted payment")
    @PatchMapping("/restore/{id}")
    public Mono<Payment> restore(@PathVariable String id) {
        return service.restore(id);
    }
}