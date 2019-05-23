package pl.coderslab.model;

import java.math.BigDecimal;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String description;
    private BigDecimal hourCost;

    public Employee(int id, String firstName, String lastName, String address, String phoneNumber, String description, BigDecimal hourCost) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.hourCost = hourCost;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getHourCost() {
        return hourCost;
    }

    public void setHourCost(BigDecimal hourCost) {
        this.hourCost = hourCost;
    }
}
