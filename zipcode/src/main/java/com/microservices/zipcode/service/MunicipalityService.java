package com.microservices.zipcode.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.microservices.zipcode.dto.MunicipalityDto;
import com.microservices.zipcode.entity.Municipality;
import com.microservices.zipcode.entity.ZipCode;
import com.microservices.zipcode.repository.MunicipalityRepository;
import com.microservices.zipcode.repository.ZipCodeRespository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MunicipalityService {
    
    private final MunicipalityRepository municipalityRepository;
    private final ZipCodeRespository zipCodeRepository;

    public MunicipalityDto createMunicipality(MunicipalityDto municipalityDto){
         // 1. Crear y guardar el municipality
        Municipality municipality = new Municipality();
        municipality.setMunicipalityName(municipalityDto.getMunicipalityName());
        Municipality saved = municipalityRepository.save(municipality);

        // 2. Crear y asociar cada ZipCode
        List<ZipCode> zipCodes = municipalityDto.getZipCodes().stream()
            .map(dto -> {
                ZipCode zc = new ZipCode();
                zc.setZipCode(dto.getZipCode());
                zc.setMunicipality(saved);   // ← asociación clave
                return zc;
            }).collect(Collectors.toList());
        
        zipCodeRepository.saveAll(zipCodes);

        // 3. Regresar DTO
        return new MunicipalityDto(
            saved.getMunicipalityName(),
            municipalityDto.getZipCodes()
        );
    }

}
