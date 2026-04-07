package pe.edu.vallegrande.mybackend.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.mybackend.model.TourPackage;
import pe.edu.vallegrande.mybackend.repository.TourPackageRepository;
import pe.edu.vallegrande.mybackend.service.TourPackageService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class TourPackageServiceImpl implements TourPackageService {

    private final TourPackageRepository repository;

    @Override
    public Flux<TourPackage> findAll() {
        return repository.findAll();
    }

    @Override
    public Flux<TourPackage> findByState(String state) {
        return repository.findByState(state);
    }

    @Override
    public Mono<TourPackage> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<TourPackage> save(TourPackage tourPackage) {
        tourPackage.setState("A");
        tourPackage.setCreatedAt(LocalDateTime.now());
        return repository.save(tourPackage);
    }

    @Override
    public Mono<TourPackage> update(String id, TourPackage tourPackage) {
        return repository.findById(id)
                .flatMap(existing -> {
                    existing.setPackageName(tourPackage.getPackageName());
                    existing.setDescription(tourPackage.getDescription());
                    existing.setPrice(tourPackage.getPrice());
                    existing.setStartDate(tourPackage.getStartDate());
                    existing.setEndDate(tourPackage.getEndDate());
                    existing.setUbigeoCode(tourPackage.getUbigeoCode());
                    existing.setDriverId(tourPackage.getDriverId());
                    existing.setUpdatedAt(LocalDateTime.now());
                    return repository.save(existing);
                });
    }

    @Override
    public Mono<TourPackage> delete(String id) {
        return repository.findById(id)
                .flatMap(pkg -> {
                    pkg.setState("I");
                    pkg.setDeletedAt(LocalDateTime.now());
                    return repository.save(pkg);
                });
    }

    @Override
    public Mono<TourPackage> restore(String id) {
        return repository.findById(id)
                .flatMap(pkg -> {
                    pkg.setState("A");
                    pkg.setRestoredAt(LocalDateTime.now());
                    return repository.save(pkg);
                });
    }
}