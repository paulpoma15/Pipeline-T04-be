package pe.edu.vallegrande.mybackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.mybackend.model.Booking;
import pe.edu.vallegrande.mybackend.model.BookingDetail;
import pe.edu.vallegrande.mybackend.repository.BookingRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    // ✅ CREATE (TRANSACCIONAL REACTIVO)
    public Mono<Booking> create(Booking booking) {

        BigDecimal total = BigDecimal.ZERO;

        // 🔥 Valores por defecto
        if (booking.getStatus() == null) booking.setStatus("P");
        if (booking.getIsPaid() == null) booking.setIsPaid(false);
        if (booking.getBookingType() == null) booking.setBookingType("P");

        // 🔥 Procesar detalles
        if (booking.getDetails() != null) {
            for (BookingDetail detail : booking.getDetails()) {
                BigDecimal subTotal = detail.getUnitPrice()
                        .multiply(BigDecimal.valueOf(detail.getQuantity()));

                detail.setSubTotal(subTotal);
                total = total.add(subTotal);
            }
        }

        booking.setTotalAmount(total);

        // 🔥 Auditoría
        booking.setCreatedAt(LocalDateTime.now());
        booking.setActive(true);

        return bookingRepository.save(booking);
    }

    // ✅ READ - LISTAR
    public Flux<Booking> findAll() {
        return bookingRepository.findByActiveTrue();
    }

    // ✅ READ - POR ID
    public Mono<Booking> findById(String id) {
        return bookingRepository.findById(id)
                .filter(Booking::getActive);
    }

    // ✅ UPDATE
    public Mono<Booking> update(String id, Booking booking) {
        return bookingRepository.findById(id)
                .flatMap(existing -> {

                    existing.setCustomerId(booking.getCustomerId());
                    existing.setTourPackageId(booking.getTourPackageId());
                    existing.setStatus(booking.getStatus());
                    existing.setIsPaid(booking.getIsPaid());
                    existing.setTotalAmount(booking.getTotalAmount());

                    // 🔥 Auditoría
                    existing.setUpdatedAt(LocalDateTime.now());

                    return bookingRepository.save(existing);
                });
    }

    // ✅ DELETE LÓGICO
    public Mono<Booking> delete(String id) {
        return bookingRepository.findById(id)
                .flatMap(booking -> {
                    booking.setActive(false);
                    booking.setDeletedAt(LocalDateTime.now());
                    return bookingRepository.save(booking);
                });
    }

    // ✅ RESTAURAR
    public Mono<Booking> restore(String id) {
        return bookingRepository.findById(id)
                .flatMap(booking -> {
                    booking.setActive(true);
                    booking.setDeletedAt(null);
                    booking.setUpdatedAt(LocalDateTime.now());
                    return bookingRepository.save(booking);
                });
    }
}