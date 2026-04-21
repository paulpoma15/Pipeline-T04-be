package pe.edu.vallegrande.mybackend.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import pe.edu.vallegrande.mybackend.model.TourPackage;

public interface TourPackageRepository extends ReactiveMongoRepository<TourPackage, String> {

    Flux<TourPackage> findByState(String state);
}