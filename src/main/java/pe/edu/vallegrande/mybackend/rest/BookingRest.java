package pe.edu.vallegrande.mybackend.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.mybackend.model.Booking;
import pe.edu.vallegrande.mybackend.service.BookingService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/api/booking")
@RequiredArgsConstructor
public class BookingRest {

    private final BookingService bookingService;

    // ✅ CREATE (POST - MONO)
    @PostMapping("/transaction")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Booking> saveBookingTransaction(@RequestBody Booking booking) {
        return bookingService.create(booking);
    }

    // ✅ READ - LISTAR (FLUX)
    @GetMapping
    public Flux<Booking> findAll() {
        return bookingService.findAll();
    }

    // ✅ READ - POR ID (MONO)
    @GetMapping("/{id}")
    public Mono<Booking> findById(@PathVariable String id) {
        return bookingService.findById(id);
    }

    // ✅ UPDATE (PUT - MONO)
    @PutMapping("/{id}")
    public Mono<Booking> update(@PathVariable String id, @RequestBody Booking booking) {
        return bookingService.update(id, booking);
    }

    // ✅ DELETE LÓGICO (PATCH)
    @PatchMapping("/delete/{id}")
    public Mono<Booking> delete(@PathVariable String id) {
        return bookingService.delete(id);
    }

    // ✅ RESTAURAR (PATCH)
    @PatchMapping("/restore/{id}")
    public Mono<Booking> restore(@PathVariable String id) {
        return bookingService.restore(id);
    }
}