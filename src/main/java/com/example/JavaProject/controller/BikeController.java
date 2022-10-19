package com.example.JavaProject.controller;
import com.example.JavaProject.repository.BikeRepo;
import com.example.JavaProject.model.Bike;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class BikeController {

    @Autowired
    BikeRepo bikeRepository;

    @GetMapping("/bikes")
    public String getBikes(Model model) {
        List<Bike> bikes = bikeRepository.findAll();
        model.addAttribute("Abikes", bikes);
        return "bikes";
    }

    @GetMapping("/bikes/create")
    public String createBike() {
        return "create";
    }

    @PostMapping("/bikes/create")
    public String bikeCreation(Bike bike) {
        bikeRepository.save(bike);
        return "redirect:/bikes";
    }

    @GetMapping("/bikes/update/{id}")
    public String bikeEdit(Model model, @PathVariable("id") Long id) {
        Bike bike = bikeRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid bike Id:" + id));
        model.addAttribute("bike", bike);
        return "update";
    }

    @PostMapping("/bikes/update/{id}")
    public String bikeUpdate(Bike model, @PathVariable("id") Long id) {
        Optional<Bike> bikeResponse = bikeRepository.findById(id);
        bikeResponse.map(bike -> {
            bike.setBrand(model.getBrand());
            bike.setModel(model.getModel());
            bike.setElectric(model.getElectric());
            return bikeRepository.save(bike);
        });
        return "redirect:/bikes";
    }

    @GetMapping("/bikes/delete/{id}")
    public String deleteBike(@PathVariable("id") long id, Model model) {
        Bike bike = bikeRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid bike Id:" + id));
        bikeRepository.delete(bike);
        model.addAttribute("bikes", bikeRepository.findAll());
        return "redirect:/bikes";
    }
}
