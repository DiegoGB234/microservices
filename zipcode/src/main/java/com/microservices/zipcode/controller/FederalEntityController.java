package com.microservices.zipcode.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.zipcode.dto.FederalEntityDto;
import com.microservices.zipcode.entity.*;
import com.microservices.zipcode.service.FederalService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/federal-entities")
@RequiredArgsConstructor
public class FederalEntityController {

    // private final ZipcodeService service;
    private final FederalService service;

    @PostMapping
    public ResponseEntity<FederalEntityDto> createFederal( @RequestBody FederalEntityDto federalEntityDto) {
        return ResponseEntity.ok(service.createFederalEntity(federalEntityDto));
    }

    @GetMapping
    public List<FederalEntity> findAll(){
        return  service.finAll();
    
    }

}
