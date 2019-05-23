package pl.coderslab.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {
    private int id;
    private LocalDate receivingDate;
    private LocalDate plannedFixingStartDate;
    private LocalDate actualFixingStartDate;
    private int employeeId;
    private String problemDescription;
    private String repairDescription;
    private String status;
    private int vehicleId;
    private double cost;
    private double partsCost;
    private BigDecimal hourCost;
    private int hours;

    public Order(int id, LocalDate receivingDate, LocalDate plannedFixingStartDate, LocalDate actualFixingStartDate, int employeeId, String problemDescription, String repairDescription, String status, int vehicleId, double cost, double partsCost, BigDecimal hourCost, int hours) {
        this.id = id;
        this.receivingDate = receivingDate;
        this.plannedFixingStartDate = plannedFixingStartDate;
        this.actualFixingStartDate = actualFixingStartDate;
        this.employeeId = employeeId;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.status = status;
        this.vehicleId = vehicleId;
        this.cost = cost;
        this.partsCost = partsCost;
        this.hourCost = hourCost;
        this.hours = hours;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(LocalDate receivingDate) {
        this.receivingDate = receivingDate;
    }

    public LocalDate getPlannedFixingStartDate() {
        return plannedFixingStartDate;
    }

    public void setPlannedFixingStartDate(LocalDate plannedFixingStartDate) {
        this.plannedFixingStartDate = plannedFixingStartDate;
    }

    public LocalDate getActualFixingStartDate() {
        return actualFixingStartDate;
    }

    public void setActualFixingStartDate(LocalDate actualFixingStartDate) {
        this.actualFixingStartDate = actualFixingStartDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
    }

    public BigDecimal getHourCost() {
        return hourCost;
    }

    public void setHourCost(BigDecimal hourCost) {
        this.hourCost = hourCost;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
