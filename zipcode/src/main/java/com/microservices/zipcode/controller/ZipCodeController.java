package com.microservices.zipcode.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.zipcode.dto.ZipCodeDto;
import com.microservices.zipcode.entity.ZipCode;
import com.microservices.zipcode.service.ZipcodeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/zip-codes")
@RequiredArgsConstructor
@Tag(name = "Zip Code API", description = "API for managing zip codes")
public class ZipCodeController {

    private final ZipcodeService service;

    @GetMapping
    @Operation(summary = "Get all zip codes", description = "Returns a list of all zip codes")
    public List<ZipCode> findAll() {
        return service.findAll();
    }

    @PostMapping
    @Operation(summary = "Post  only one zipcode" , description = "post")
    public ZipCodeDto createZipCode(ZipCodeDto dto){
        return service.createZipCode(dto);
    }
    @GetMapping("/{id}")
    @Operation(summary = "find one", description = "this return only registers with information relasition")
    public ZipCode findOneById(@PathParam("id") Long id){
        return service.findOne(id);
    }
}
