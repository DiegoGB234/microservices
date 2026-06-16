package com.microservices.zipcode.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservices.zipcode.dto.FederalEntityDto;
import com.microservices.zipcode.entity.FederalEntity;
import com.microservices.zipcode.repository.FederalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FederalService {
    private final  FederalRepository federalRepository;


    // public FederalService(FederalRepository federalRepository) {
    //     this.federalRepository = federalRepository;
    // }

    public List<FederalEntity> finAll(){
        return federalRepository.findAll();

    }

    public FederalEntityDto createFederalEntity( FederalEntityDto federalEntityDto){ 
        FederalEntity entity = new FederalEntity();
        entity.setFederalEntityName(federalEntityDto.getFederalEntityName());
        FederalEntity saved = federalRepository.save(entity);
        return  new FederalEntityDto(
            saved.getFederalEntityName()
        );

    
    }
}
