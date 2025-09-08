package pe.edu.vallegrande.mybackend.repository;

import pe.edu.vallegrande.mybackend.model.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TourPackageRepository extends JpaRepository<TourPackage, Long> {

    // ⚙️🔍 Definir método Listar por Estado
    List<TourPackage> findByState(String state);

}
