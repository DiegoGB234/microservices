package com.microservices.zipcode.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private Long id;
    @Column(name="name_neighborhood", columnDefinition = "VARCHAR(255) COLLATE utf8mb4_general_ci")
    private String neighborhoodName;

    @ManyToOne
    @JoinColumn(name = "zip_code_id")
    private ZipCode zipCode;
}