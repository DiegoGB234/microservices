package com.microservices.zipcode.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "zip_code")
@AllArgsConstructor
@NoArgsConstructor
public class ZipCode {

    @Id
    private Long id;

    private String zipCode;

    @OneToMany(mappedBy = "Neighborhood")
    private List<Neighborhood> neighborhoods;
}