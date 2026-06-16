package com.microservices.zipcode.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.zipcode.dto.NeighborhoodDto;
import com.microservices.zipcode.entity.Neighborhood;
import com.microservices.zipcode.repository.NeighborhoodRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NeighborhoodService {
    private final NeighborhoodRepository neighborhoodRepository;

    public NeighborhoodDto createNeighborhood(NeighborhoodDto neighborhoodDto){
        Neighborhood entity = new Neighborhood();
        entity.setNeighborhoodName(neighborhoodDto.getNeighborhoodName());
        
        Neighborhood saved = neighborhoodRepository.save(entity);
        return new NeighborhoodDto(
            saved.getNeighborhoodName()
        );
    }

}
