package pe.edu.vallegrande.mybackend.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookingDetail {

    private Integer quantity;

    private BigDecimal unitPrice;

    private BigDecimal subTotal;

    private String serviceExtra;
}