package pe.edu.vallegrande.mybackend.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.mybackend.model.Payment;
import pe.edu.vallegrande.mybackend.model.PaymentDetail;
import pe.edu.vallegrande.mybackend.repository.PaymentRepository;
import pe.edu.vallegrande.mybackend.service.PaymentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository repository;

    @Override
    public Flux<Payment> findAll() {
        return repository.findByActiveTrue();
    }

    @Override
    public Mono<Payment> findById(String id) {
        return repository.findById(id)
                .filter(Payment::getActive);
    }

    @Override
    public Mono<Payment> create(Payment payment) {

        BigDecimal total = BigDecimal.ZERO;

        if (payment.getDetails() != null) {
            for (PaymentDetail d : payment.getDetails()) {
                BigDecimal sub = d.getUnitPrice()
                        .multiply(BigDecimal.valueOf(d.getQuantity()));
                d.setSubTotal(sub);
                total = total.add(sub);
            }
        }

        payment.setAmount(total);
        payment.setCreatedAt(LocalDateTime.now());
        payment.setActive(true);
        payment.setStatus("P");

        return repository.save(payment);
    }

    @Override
    public Mono<Payment> update(String id, Payment payment) {
        return repository.findById(id)
                .flatMap(existing -> {
                    payment.setId(id);
                    payment.setUpdatedAt(LocalDateTime.now());
                    payment.setCreatedAt(existing.getCreatedAt());
                    payment.setActive(existing.getActive());
                    return repository.save(payment);
                });
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.findById(id)
                .flatMap(payment -> {
                    payment.setActive(false);
                    payment.setDeletedAt(LocalDateTime.now());
                    return repository.save(payment);
                })
                .then();
    }

    @Override
    public Mono<Payment> restore(String id) {
        return repository.findById(id)
                .flatMap(payment -> {
                    payment.setActive(true);
                    payment.setDeletedAt(null);
                    payment.setUpdatedAt(LocalDateTime.now());
                    return repository.save(payment);
                });
    }
}