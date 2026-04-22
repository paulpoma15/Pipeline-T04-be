package pe.edu.vallegrande.mybackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "payment")
public class Payment {

    @Id
    private String id;

    private String bookingId;

    private BigDecimal amount;
    private LocalDateTime paymentDate = LocalDateTime.now();
    private String paymentMethod;
    private String status; // P=Pending, C=Completed, A=Anulado

    // 🔥 Auditoría
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private Boolean active = true;

    // 🔥 DETALLE EMBEBIDO
    private List<PaymentDetail> details;
}