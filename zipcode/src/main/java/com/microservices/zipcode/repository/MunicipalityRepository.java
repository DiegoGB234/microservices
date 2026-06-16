package com.microservices.zipcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.zipcode.entity.Municipality;

public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {

}
