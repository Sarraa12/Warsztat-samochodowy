package pl.coderslab.model;

import java.time.LocalDate;

public class Vehicle {
    private int id;
    private String model;
    private String brand;
    private LocalDate dateOfProduction;
    private String registrationNumber;
    private LocalDate nextReview;

    public Vehicle(int id, String model, String brand, LocalDate dateOfProduction, String registrationNumber, LocalDate nextReview) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.dateOfProduction = dateOfProduction;
        this.registrationNumber = registrationNumber;
        this.nextReview = nextReview;
    }

    public Vehicle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(LocalDate dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public LocalDate getNextReview() {
        return nextReview;
    }

    public void setNextReview(LocalDate nextReview) {
        this.nextReview = nextReview;
    }
}
