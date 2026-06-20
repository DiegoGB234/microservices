package com.microservices.zipcode.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.zipcode.dto.MunicipalityDto;
import com.microservices.zipcode.service.MunicipalityService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;  


@RestController
@RequestMapping("/municipalities")
@RequiredArgsConstructor
public class MunicipalityController {
    private final  MunicipalityService service;

    @PostMapping
    public ResponseEntity<MunicipalityDto> createMunicipality(MunicipalityDto municipalityDto){
        return ResponseEntity.ok(service.createMunicipality(municipalityDto));
    }

    @GetMapping
    public String getMethodName() {
        return "HHOOOOO";
    }
    
}
