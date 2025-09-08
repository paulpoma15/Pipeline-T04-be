package pe.edu.vallegrande.mybackend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "tour_package")  // ✅ Nombre exacto de la tabla en SQL Server
public class TourPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ✅ Generación automática del ID
    @Column(name = "tour_package_id")  // 🗄️ Nombre correcto en la BD
    private Long id;                   // ☕ Atributo en Java

    @Column(name = "package_name", nullable = false, length = 100)
    private String packageName;

    @Column(name = "description")  // ✅ Nombre correcto en la BD
    private String description;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "duration_days", nullable = false)
    private Integer durationDays;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "state", length = 1, nullable = false)
    private String state;

}
