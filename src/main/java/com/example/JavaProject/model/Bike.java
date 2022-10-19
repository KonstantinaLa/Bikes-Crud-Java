package com.example.JavaProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "electric")
    private boolean electric;

    public Bike(){
    }

    public Bike(String model, String brand, boolean electric) {
        this.model = model;
        this.brand = brand;
        this.electric = electric;
    }

    public Long getId(){
        return id;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public boolean getElectric(){
        return electric;
    }

    public void setElectric(boolean electric){
        this.electric = electric;
    }

}