package com.microservicios.parcel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservicios.parcel.entity.Parcel;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {

}
