package com.microservices.zipcode.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.zipcode.dto.FederalEntityDto;
import com.microservices.zipcode.entity.*;
import com.microservices.zipcode.service.ZipcodeService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/federal-entities")
@RequiredArgsConstructor
public class FederalEntityController {

    private final ZipcodeService service;

    @GetMapping
    public List<FederalEntity> findAll() {
        // return service.getFederalEntities();
        return List.of(
            new FederalEntity(1L, "Chiapas"),
            new FederalEntity(2L, "Oaxaca"),
            new FederalEntity(3L, "Puebla")
        );
    }


    // @GetMapping("/{id}/details")
    // public FederalEntityDto getDetails(
    //         @PathVariable Long id) {

    //     // return service.getFederalEntityDetails(id);
    // }
}
