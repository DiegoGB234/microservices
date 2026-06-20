package com.microservicios.parcel.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;

@Entity
@Data
@Table(name = "parcel")
@AllArgsConstructor
@NoArgsConstructor
public class Parcel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "remitent_name")
    private String remitentName;

    @Column(name="status")
    private String status;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_address")
    private String receiverAddress;
    
    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "entry_date", columnDefinition = "TIMESTAMP")
    private  LocalDate entryDate;

    @Column(name = "departure_date", columnDefinition = "TIMESTAMP")
    private LocalDate departureDate;

    @Column(name = "delivery_date", columnDefinition = "TIMESTAMP")
    private LocalDate deliveryDate;

    @Column(name = "cost", columnDefinition = "DECIMAL(10,2)")
    private Double cost;

    @Column(name = "email")
    private String email;

}
