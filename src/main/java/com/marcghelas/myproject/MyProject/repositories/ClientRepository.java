/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcghelas.myproject.MyProject.repositories;

import com.marcghelas.myproject.MyProject.entities.Client;
import com.marcghelas.myproject.MyProject.entities.VehicleRentsDTO;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Student
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

//    @Query("SELECT 9 as days, 'BMW', 'X' as brand")
//    @Query("SELECT name FROM Client where id=?1")
    @Query(value = "SELECT RH.days, V.brand, V.model FROM  Clients C "
            + "INNER JOIN Rent_History RH ON RH.id_client=C.id "
            + "INNER JOIN Vehicles V ON RH.id_vehicle=V.id "
            + "WHERE C.id=?1", nativeQuery = true)
    public List<VehicleRentsDTO> findVehicleRents(Long id);

}
