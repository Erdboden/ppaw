/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcghelas.myproject.MyProject.services;

import com.marcghelas.myproject.MyProject.entities.Client;
import com.marcghelas.myproject.MyProject.entities.RentHistory;
import com.marcghelas.myproject.MyProject.repositories.RentHistoryRepository;
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
public class RentHistoryService {
     @Autowired
    private RentHistoryRepository rentHistoryRepository;



//         public List<RentHistory> findByClientId(Long idClient) {
//        return rentHistoryRepository.findByIdClient(idClient);
//    }
}
