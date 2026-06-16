package com.microservices.zipcode.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "federal_entity")
@AllArgsConstructor
@NoArgsConstructor

public class FederalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "federal_entity_name", nullable = false)
    private String federalEntityName;

    @OneToMany(mappedBy = "federalEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Municipality> municipalities = new ArrayList<>();
}