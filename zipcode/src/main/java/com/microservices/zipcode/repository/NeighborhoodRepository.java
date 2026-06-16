package com.microservices.zipcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.zipcode.entity.Neighborhood;

public interface NeighborhoodRepository  extends JpaRepository<Neighborhood,Long>{

}
