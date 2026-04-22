package pe.edu.vallegrande.mybackend.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDetail {

    private String description;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal subTotal;
}