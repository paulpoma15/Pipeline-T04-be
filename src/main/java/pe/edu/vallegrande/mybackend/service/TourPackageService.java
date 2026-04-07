package pe.edu.vallegrande.mybackend.service;

import pe.edu.vallegrande.mybackend.model.TourPackage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TourPackageService {

    Flux<TourPackage> findAll();

    Flux<TourPackage> findByState(String state);

    Mono<TourPackage> findById(String id);

    Mono<TourPackage> save(TourPackage tourPackage);

    Mono<TourPackage> update(String id, TourPackage tourPackage);

    Mono<TourPackage> delete(String id);

    Mono<TourPackage> restore(String id);
}