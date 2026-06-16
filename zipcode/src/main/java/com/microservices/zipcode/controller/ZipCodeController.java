package com.microservices.zipcode.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.zipcode.service.ZipcodeService;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/zip-codes")
@RequiredArgsConstructor
@Tag(name = "Zip Code API", description = "API for managing zip codes")
public class ZipCodeController {

    private final ZipcodeService service;

    // @GetMapping
    // @Operation(summary = "Get all zip codes", description = "Returns a list of all zip codes")
    // public List<ZipCode> findAll() {
    //     return service.getZipCodes();
    // }
}
