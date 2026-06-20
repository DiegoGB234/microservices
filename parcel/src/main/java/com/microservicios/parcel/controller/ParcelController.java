package com.microservicios.parcel.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.parcel.dto.ParcelDto;
import com.microservicios.parcel.entity.Parcel;
import com.microservicios.parcel.service.ParcelService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;




@RestController
@RequestMapping("/api/parcel")
@RequiredArgsConstructor
@Tag(name = "Parcel API", description = "API for managing parcels")
public class ParcelController {

    private final ParcelService service;

    @GetMapping()
    public List<Parcel> getParcels() {
        return service.getAllParcels();
    }

    @GetMapping("/{id}")
    public Parcel getParcel(@PathVariable Long id) {
        return service.getParcelById(id);
    }
    
    // @PostMapping()
    // public Parcel createParcel(@RequestBody ParcelDto parcel) {
    //     System.out.println("Received parcel data: " + parcel);
    //     System.out.println(parcel);
    //     return service.createParcel(parcel); 
    // }
    @PostMapping()
    public ResponseEntity<String> createParcel(@RequestBody String body) {
        System.out.println("BODY: " + body);
        return ResponseEntity.ok(body);
    }


}
