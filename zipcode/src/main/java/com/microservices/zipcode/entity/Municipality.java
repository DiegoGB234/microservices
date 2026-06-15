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
@Table(name = "municipality")
@AllArgsConstructor
@NoArgsConstructor
public class Municipality {

    @Id
    private Long id;
    @Column(name = "federal_entity_id")
    private Long federalEntityId;
    @Column(name = "municipality_name")
    private String municipalityName;
}
