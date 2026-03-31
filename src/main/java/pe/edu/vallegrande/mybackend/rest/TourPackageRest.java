package pe.edu.vallegrande.mybackend.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.mybackend.model.TourPackage;
import pe.edu.vallegrande.mybackend.service.TourPackageService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/api/tour-packages") // http://localhost:8086/webjars/swagger-ui/index.html - http://localhost:8086/v1/api/tour-packages
@RequiredArgsConstructor
@Tag(name = "Tour Packages API", description = "Reactive CRUD with MongoDB")
public class TourPackageRest {

    private final TourPackageService service;

    // ✅ LISTAR TODOS
    @GetMapping
    @Operation(summary = "LIST ALL", description = "Get all tour packages")
    public Flux<TourPackage> findAll() {
        return service.findAll();
    }

    // ✅ LISTAR POR ESTADO
    @GetMapping("/state/{state}")
    @Operation(summary = "LIST BY STATE", description = "Get packages by state (A/I)")
    public Flux<TourPackage> findByState(@PathVariable String state) {
        return service.findByState(state);
    }

    // ✅ LISTAR POR ID
    @GetMapping("/{id}")
    @Operation(summary = "GET BY ID", description = "Get package by id")
    public Mono<TourPackage> findById(@PathVariable String id) {
        return service.findById(id);
    }

    // ✅ CREAR
    @PostMapping
    @Operation(summary = "CREATE", description = "Create new tour package")
    public Mono<TourPackage> save(@RequestBody TourPackage tourPackage) {
        return service.save(tourPackage);
    }

    // ✅ EDITAR
    @PutMapping("/{id}")
    @Operation(summary = "UPDATE", description = "Update tour package")
    public Mono<TourPackage> update(@PathVariable String id,
                                    @RequestBody TourPackage tourPackage) {
        return service.update(id, tourPackage);
    }

    // ✅ ELIMINADO LÓGICO
    @PatchMapping("/delete/{id}")
    @Operation(summary = "LOGICAL DELETE", description = "Set state to I")
    public Mono<TourPackage> delete(@PathVariable String id) {
        return service.delete(id);
    }

    // ✅ RESTAURAR
    @PatchMapping("/restore/{id}")
    @Operation(summary = "LOGICAL RESTORE", description = "Set state to A")
    public Mono<TourPackage> restore(@PathVariable String id) {
        return service.restore(id);
    }
}