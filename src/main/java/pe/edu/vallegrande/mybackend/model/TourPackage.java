package pe.edu.vallegrande.mybackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document(collection = "tour_package")
public class TourPackage {

    @Id
    private String id;   // 🔹 ObjectId de Mongo

    private String packageName;
    private String description;
    private BigDecimal price;

    private LocalDate startDate;
    private LocalDate endDate;

    private String ubigeoCode;
    private Integer driverId;

    private String state; // A / I

    // 🔹 Audit fields
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private LocalDateTime restoredAt;
}