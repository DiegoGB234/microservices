package com.microservices.zipcode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.zipcode.entity.ZipCode;
public interface ZipCodeRespository extends JpaRepository<ZipCode,Long> {
    

}
