package pe.edu.vallegrande.mybackend.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.edu.vallegrande.mybackend.model.Booking;
import reactor.core.publisher.Flux;

public interface BookingRepository extends ReactiveMongoRepository<Booking, String> {

    // ✅ Solo registros activos (para eliminar lógico)
    Flux<Booking> findByActiveTrue();
}