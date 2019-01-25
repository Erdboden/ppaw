/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcghelas.myproject.MyProject.repositories;

import com.marcghelas.myproject.MyProject.entities.ClientRentsDTO;
import com.marcghelas.myproject.MyProject.entities.MeanTimeDTO;
import com.marcghelas.myproject.MyProject.entities.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Student
 */
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long>  {

    @Query(value = "SELECT RH.days, C.name, C.surname FROM  Vehicles V "
            + "INNER JOIN Rent_History RH ON RH.id_vehicle=V.id "
            + "INNER JOIN Clients C ON RH.id_client=C.id "
            + "WHERE V.id=?1", nativeQuery = true)
    List<ClientRentsDTO> findClientRents(Long id);


    @Query(value = "SELECT avg(RH.days) as mean FROM  Clients C " +
            "INNER JOIN Rent_History RH ON RH.id_client=C.id " +
            "INNER JOIN Vehicles V ON RH.id_vehicle=V.id " +
            "WHERE C.id=?1 AND V.brand=?2 " +
            "GROUP BY C.name, C.surname, V.brand", nativeQuery = true)
    MeanTimeDTO getMeanRentTime(Long id, String brand);
}
