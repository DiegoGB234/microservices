package com.microservices.zipcode.service;



import java.util.List;
import org.springframework.stereotype.Service;

import com.microservices.zipcode.dto.ZipCodeDto;
import com.microservices.zipcode.entity.Municipality;
import com.microservices.zipcode.entity.ZipCode;
import com.microservices.zipcode.repository.MunicipalityRepository;
import com.microservices.zipcode.repository.ZipCodeRespository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ZipcodeService {

    private final ZipCodeRespository zipCodeRespository;
    private final MunicipalityRepository municipalityRepository;

    public List<ZipCode> findAll(){
    return zipCodeRespository.findAll();
    }

    public ZipCode findOne(Long id){
        return zipCodeRespository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro ningun valor"));
    }
    
    public ZipCodeDto  createZipCode(ZipCodeDto zipCodeDto){
        ZipCode zipCode = new ZipCode();
        Municipality municipality = municipalityRepository.findById(zipCodeDto.getMunicipality())
                                    .orElseThrow(()-> new RuntimeException("Municipio no encontrado con ID: " + zipCodeDto.getMunicipality()));
        zipCode.setZipCode(zipCodeDto.getZipCode());
        zipCode.setMunicipality(municipality);
        ZipCode saved = zipCodeRespository.save(zipCode);

        return toDto(saved);

    }


    private ZipCodeDto toDto(ZipCode zipCode) {
        ZipCodeDto dto = new ZipCodeDto();
        dto.setZipCode(zipCode.getZipCode());
        dto.setMunicipality(zipCode.getMunicipality().getId());
        return dto;
    }
    
}
