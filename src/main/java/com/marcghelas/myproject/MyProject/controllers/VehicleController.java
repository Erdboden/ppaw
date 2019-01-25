package com.marcghelas.myproject.MyProject.controllers;

import com.marcghelas.myproject.MyProject.entities.ClientRentsDTO;
import com.marcghelas.myproject.MyProject.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Marc on 24.01.2019.
 */
@Controller
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "/vehicles", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("vehicles", vehicleService.findAll());
        return "vehicles";
    }

    @RequestMapping(value = "/vehicles", method = RequestMethod.POST)
    public String clientVehicles(@RequestParam("vehicle") Long vehicleId, Model model) {
        List<ClientRentsDTO> clients = vehicleService.findClientRents(vehicleId);
        model.addAttribute("clients", clients);
        model.addAttribute("vehicles", vehicleService.findAll());
        return "vehicles";
    }
}
