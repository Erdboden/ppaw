package com.marcghelas.myproject.MyProject.controllers;

import com.marcghelas.myproject.MyProject.entities.*;
import com.marcghelas.myproject.MyProject.services.ClientService;
import com.marcghelas.myproject.MyProject.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

/**
 * Created by Marc on 24.01.2019.
 */
@Controller
public class RentHistoryController {
    @Autowired
    VehicleService vehicleService;
    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/rent-history", method = RequestMethod.GET)
    public String index(Model model) {
        List<Vehicle> vehicles = vehicleService.findAll();
        List<String> brands = new ArrayList<>();
        for (Vehicle vehicle :
                vehicles) {
            if (!brands.contains(vehicle.getBrand())) {
                brands.add(vehicle.getBrand());
            }
        }

        List<Client> clients = clientService.findAll();
        List<ClientMeanRentsDTO> meanRentList = new ArrayList<>();
        for (Client client : clients) {
            Map<String, Integer> map = new HashMap<>();
            for (String brand : brands) {
                MeanTimeDTO meanRentTime = vehicleService.getMeanRentTime(client.getId(), brand);
                if (meanRentTime == null) {
                    map.put(brand, 0);
                } else {
                    map.put(brand, meanRentTime.getMean());
                }
            }
            ClientMeanRentsDTO clientMeanRentsDTO = new ClientMeanRentsDTO();
            clientMeanRentsDTO.setName(client.getName());
            clientMeanRentsDTO.setSurname(client.getSurname());
            clientMeanRentsDTO.setMap(map);

            meanRentList.add(clientMeanRentsDTO);
        }


        model.addAttribute("client_rents", meanRentList);
        brands.add(0, "Client");
        model.addAttribute("brands", brands);
        return "rent-history";
    }

}
