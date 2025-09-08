package pe.edu.vallegrande.mybackend.service;

import pe.edu.vallegrande.mybackend.model.TourPackage;
import java.util.List;
import java.util.Optional;

public interface TourPackageService {

    // ⚙️🔍 Definir método Listar Todos
    List<TourPackage> findAll();

    // ⚙️🔍 Definir método Listar por Estado
    List<TourPackage> findByState(String state);

    // ⚙️🔍 Definir método Listar por ID
    Optional<TourPackage> findById(Long id);

    // ⚙️✅ Definir método Registrar
    TourPackage save(TourPackage tourPackage);

    // ⚙️✏️ Definir método Actualizar
    TourPackage update(TourPackage tourPackage);

    // ⚙️❌ Definir método Eliminar (Cambio de Estado) por ID
    TourPackage delete(Long id);

    // ⚙️♻️ Definir método Restaurar (Cambio de Estado) por ID
    TourPackage restore(Long id);

}
