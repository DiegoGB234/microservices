package com.microservices.zipcode.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "neighborhood")
@AllArgsConstructor
@NoArgsConstructor
public class Neighborhood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "neighborhood_name", nullable = false, columnDefinition = "VARCHAR(255) COLLATE \"es-ES-x-icu\"")
    private String neighborhoodName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zip_code_id", referencedColumnName = "id", nullable = false)
    private ZipCode zipCode;
}