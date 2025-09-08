package pe.edu.vallegrande.mybackend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.mybackend.model.TourPackage;
import pe.edu.vallegrande.mybackend.service.TourPackageService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")          // ✅ Permitir conexión con Angular
@RestController
@RequestMapping("/v1/api/tour-packages")  // ✅ http://localhost:8086/v1/api/tour-packages
public class TourPackageRest {

    // ✅ Inyección del service
    private final TourPackageService tourPackageService;

    @Autowired
    public TourPackageRest(TourPackageService tourPackageService) {
        this.tourPackageService = tourPackageService;
    }

    // 🌐🔍 Mapear Endpoint Listar Todos - tipo GET
    @GetMapping
    public List<TourPackage> findAll() {
        return tourPackageService.findAll();
    }

    // 🌐🔍 Mapear Endpoint Listar por Estado - tipo GET
    @GetMapping("/state/{state}")
    public List<TourPackage> findByState(@PathVariable String state) {
        return tourPackageService.findByState(state);
    }

    // 🌐🔍 Mapear Endpoint Listar por ID - tipo GET
    @GetMapping("/{id}")
    public Optional<TourPackage> findById(@PathVariable Long id) {
        return tourPackageService.findById(id);
    }

    // 🌐✅ Mapear Endpoint Registrar - tipo POST
    @PostMapping("/save")
    public TourPackage save(@RequestBody TourPackage tourPackage) {
        return tourPackageService.save(tourPackage);
    }

    // 🌐✏️ Mapear Endpoint Actualizar - tipo PUT
    @PutMapping("/update/{id}")
    public TourPackage update(@PathVariable Long id, @RequestBody TourPackage tourPackage) {
        tourPackage.setId(id);
        return tourPackageService.update(tourPackage);
    }

    // 🌐❌ Mapear Endpoint Eliminar (Cambio de Estado) por ID - tipo PATCH
    @PatchMapping("/delete/{id}")
    public TourPackage delete(@PathVariable Long id) {
        return tourPackageService.delete(id);
    }

    // 🌐♻️ Mapear Endpoint Restaurar (Cambio de Estado) por ID - tipo PATCH
    @PatchMapping("/restore/{id}")
    public TourPackage restore(@PathVariable Long id) {
        return tourPackageService.restore(id);
    }
}
