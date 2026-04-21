package pe.edu.vallegrande.mybackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "booking")
public class Booking {

    @Id
    private String id;

    private String customerId;
    private String tourPackageId;

    private LocalDateTime bookingDate = LocalDateTime.now();

    private String bookingType; // P=Presencial, V=Virtual
    private BigDecimal totalAmount;

    private String status; // P=Pendiente, C=Confirmada, R=Rechazada
    private Boolean isPaid = false;

    // 🔥 CAMPOS DE AUDITORÍA (OBLIGATORIO)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Boolean active = true;

    // 📦 DETALLE EMBEBIDO (cabecera + detalle)
    private List<BookingDetail> details;
}