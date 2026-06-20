package com.microservices.zipcode.service;

import java.util.List;
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

    public Neighborhood findOne(Long id){
        return neighborhoodRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }

    public List<Neighborhood> findAll(){
        return neighborhoodRepository.findAll();
    }
}
