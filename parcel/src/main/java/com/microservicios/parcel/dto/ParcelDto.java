package com.microservicios.parcel.dto;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor()
@NoArgsConstructor()
public class ParcelDto {
    private String remitentName;
    private String status;
    private String receiverName;
    private String receiverAddress;
    private String zipCode;
    private LocalDate entryDate;
    private LocalDate departureDate;
    private LocalDate deliveryDate;
    private Double cost;
    private String email;

}
