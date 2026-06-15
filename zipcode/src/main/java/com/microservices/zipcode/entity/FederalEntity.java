package com.microservices.zipcode.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "federal_entity")
public class FederalEntity {

    @Id
    private Long id;
    @Column(name = "federal_entity_name", columnDefinition = "VARCHAR(255) COLLATE utf8mb4_general_ci")
    private String federalEntityName;
}