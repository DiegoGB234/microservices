package com.microservicios.parcel.service;

import org.springframework.stereotype.Service;

import com.microservicios.parcel.dto.ParcelDto;
import com.microservicios.parcel.entity.Parcel;
import com.microservicios.parcel.repository.ParcelRepository;
import java.util.List; 

@Service
public class ParcelService {

    private final ParcelRepository repository;

    public ParcelService(ParcelRepository repository) {
        this.repository = repository;
    }

    public List<Parcel> getAllParcels() {
        return repository.findAll();
    }

    public Parcel getParcelById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Parcel createParcel(ParcelDto parcel) {
        Parcel newParcel = new Parcel();
        newParcel.setRemitentName(parcel.getRemitentName());
        newParcel.setReceiverName(parcel.getReceiverName());
        newParcel.setStatus(parcel.getStatus());
        newParcel.setReceiverAddress(parcel.getReceiverAddress());
        newParcel.setZipCode(parcel.getZipCode());
        newParcel.setEntryDate(parcel.getEntryDate());
        newParcel.setDepartureDate(parcel.getDepartureDate());
        newParcel.setDeliveryDate(parcel.getDeliveryDate());
        newParcel.setCost(parcel.getCost());
        newParcel.setEmail(parcel.getEmail());
        return repository.save(newParcel);
    }

}
