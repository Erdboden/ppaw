/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcghelas.myproject.MyProject.services;

import com.marcghelas.myproject.MyProject.entities.*;
import com.marcghelas.myproject.MyProject.repositories.VehicleRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Student
 */
@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> findAll() {
        return StreamSupport.stream(vehicleRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public List<ClientRentsDTO> findClientRents(Long id){
        return vehicleRepository.findClientRents(id);
    }

    public MeanTimeDTO getMeanRentTime(Long id, String brand) {
        return vehicleRepository.getMeanRentTime(id, brand);
    }
}
