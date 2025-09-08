package pe.edu.vallegrande.mybackend.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.mybackend.model.TourPackage;
import pe.edu.vallegrande.mybackend.repository.TourPackageRepository;
import pe.edu.vallegrande.mybackend.service.TourPackageService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TourPackageServiceImpl implements TourPackageService {

    // ✅ Inyección del repository
    private final TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageServiceImpl(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    // 🛠️🔍 Implementación del método Listar Todos
    @Override
    public List<TourPackage> findAll() {
        log.info("Listando todos los paquetes turísticos");
        return tourPackageRepository.findAll();
    }

    // 🛠️🔍 Implementación del método Listar por Estado
    @Override
    public List<TourPackage> findByState(String state) {
        log.info("Listando paquetes turísticos por estado: {}", state);
        return tourPackageRepository.findByState(state);
    }

    // 🛠️🔍 Implementación del método Listar por ID
    @Override
    public Optional<TourPackage> findById(Long id) {
        log.info("Buscando paquete turístico por ID: {}", id);
        return tourPackageRepository.findById(id);
    }

    // 🛠️✅ Implementación del método Registrar
    @Override
    public TourPackage save(TourPackage tourPackage) {
        log.info("Registrando paquete turístico: {}", tourPackage);
        tourPackage.setState("A");
        return tourPackageRepository.save(tourPackage);
    }

    // 🛠️✏️ Implementación del método Actualizar
    @Override
    public TourPackage update(TourPackage tourPackage) {
        log.info("Editando paquete turístico: {}", tourPackage);
        tourPackage.setState("A");
        return tourPackageRepository.save(tourPackage);
    }

    // 🛠️❌ Implementación del método Eliminar (Cambio de Estado) por ID
    @Override
    public TourPackage delete(Long id) {
        log.info("Eliminando paquete turístico con ID: {}", id);
        TourPackage tourPackage = tourPackageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TourPackage not found"));
        tourPackage.setState("I");
        return tourPackageRepository.save(tourPackage);
    }

    // 🛠️♻️ Implementación del método Restaurar (Cambio de Estado) por ID
    @Override
    public TourPackage restore(Long id) {
        log.info("Restaurando paquete turístico con ID: {}", id);
        TourPackage tourPackage = tourPackageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TourPackage not found"));
        tourPackage.setState("A");
        return tourPackageRepository.save(tourPackage);
    }
}
