/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.marcghelas.myproject.MyProject.controllers;

import com.marcghelas.myproject.MyProject.entities.VehicleRentsDTO;
import com.marcghelas.myproject.MyProject.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Student
 */
@Controller
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String index(Model model) {
        System.out.println(clientService.findAll());
        model.addAttribute("clients", clientService.findAll());
        return "clients";
    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public String clientVehicles(@RequestParam("client") Long clientId, Model model) {
        List<VehicleRentsDTO> rents = clientService.findVehicleRents(clientId);
        model.addAttribute("vehicles", rents);
        model.addAttribute("clients", clientService.findAll());
        return "clients";
    }
}
