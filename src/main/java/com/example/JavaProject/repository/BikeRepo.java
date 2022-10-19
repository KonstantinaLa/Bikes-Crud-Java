package com.example.JavaProject.repository;
import com.example.JavaProject.model.Bike;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepo extends JpaRepository<Bike, Long >{

}
