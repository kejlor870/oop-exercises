package org.example.model;

public class ElectricScooter extends Vehicle{
    private static final double START_FEE = 4.0;

    public ElectricScooter(int id, String brand, String model) {
        super(id, brand, model, 15.0);
    }

    @Override
    public double calculateCost(int hours) {
        if(hours <= 0) throw new IllegalArgumentException("Podano nieodpowiednią liczbe godzin.");

        return (getHourlyRate() * hours) + START_FEE;
    }
}
