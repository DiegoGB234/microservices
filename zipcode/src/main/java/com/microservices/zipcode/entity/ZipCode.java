package com.microservices.zipcode.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "zip_code", nullable = false, unique = true)
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipality_id", referencedColumnName = "id", nullable = false)
    private Municipality municipality;

    @OneToMany(mappedBy = "zipCode", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Neighborhood> neighborhoods = new ArrayList<>();
}