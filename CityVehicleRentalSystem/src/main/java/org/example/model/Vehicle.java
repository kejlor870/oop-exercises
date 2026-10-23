package org.example.model;

public abstract class Vehicle {
    private final int id;
    private final String brand;
    private final String model;
    private final double hourlyRate;
    private boolean available = true;

    public Vehicle(int id, String brand, String model, double hourlyRate){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.hourlyRate = hourlyRate;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rent(){
        if(this.available){
            this.available = false;

        } else {
            throw new IllegalStateException("Pojazd jest już wypożyczony");
        }
    }

    public void returnVehicle(){
        if(!this.available){
            this.available = true;

        } else {
            throw new IllegalStateException("Pojazd jest już dostępny");
        }
    }

    public abstract double calculateCost(int hours);

}
