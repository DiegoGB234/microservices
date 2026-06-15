package com.microservices.zipcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.microservices.zipcode.entity.ZipCode;

// @Repository
public interface ZipCodeRespository extends JpaRepository<ZipCode,Long> {
    

}
