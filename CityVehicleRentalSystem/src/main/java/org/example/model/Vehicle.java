package org.example.model;

import org.example.interfaces.Rentable;

public abstract class Vehicle implements Rentable {
    private final int id;
    private final String brand;
    private final String model;
    private final double hourlyRate;
    private boolean available = true;

    public Vehicle(int id, String brand, String model, double hourlyRate){
        // Validation
        if(id < 0) throw new IllegalArgumentException("ID musi być większe od zera.");
        if(brand == null || brand.isBlank()) throw new IllegalArgumentException("Marka nie może być pusta.");
        if(model == null || model.isBlank()) throw new IllegalArgumentException("Model nie może być pusty.");
        if(!Double.isFinite(hourlyRate) || hourlyRate <= 0.0) throw new IllegalArgumentException("Cena musi być dodatnia i skończona.");

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

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void rent(){
        if(this.available){
            this.available = false;

        } else {
            throw new IllegalStateException("Pojazd jest już wypożyczony");
        }
    }

    @Override
    public void returnVehicle(){
        if(!this.available){
            this.available = true;

        } else {
            throw new IllegalStateException("Pojazd jest już dostępny");
        }
    }

    public abstract double calculateCost(int hours);

}
