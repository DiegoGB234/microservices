package com.microservices.zipcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.zipcode.entity.FederalEntity;

public interface FederalRepository extends JpaRepository<FederalEntity, Long> {

}
