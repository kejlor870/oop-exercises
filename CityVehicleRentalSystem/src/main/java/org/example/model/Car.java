package org.example.model;

public class Car extends Vehicle{
    private static final double RESERVATION_FEE = 25.0;

    public Car(int id, String brand, String model) {
        super(id, brand, model, 50);
    }

    @Override
    public double calculateCost(int hours) {
        if(hours <= 0) throw new IllegalArgumentException("Podano nieodpowiednią liczbe godzin.");

        return (getHourlyRate() * hours) + RESERVATION_FEE;
    }
}
