package com.microservices.zipcode.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.zipcode.dto.NeighborhoodDto;
import com.microservices.zipcode.service.NeighborhoodService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/neighborhoods")
@RequiredArgsConstructor
public class NeighborhoodController {

    public final  NeighborhoodService service;

    @PostMapping
    public ResponseEntity<NeighborhoodDto> createNeighborhood(NeighborhoodDto neighborhoodDto){
        return ResponseEntity.ok(service.createNeighborhood(neighborhoodDto));
    }

    @GetMapping()
    public ResponseEntity<String> findAll(){
        return ResponseEntity.ok("find all neighborhoods");
    }


}
