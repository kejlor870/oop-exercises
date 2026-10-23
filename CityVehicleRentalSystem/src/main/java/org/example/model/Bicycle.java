package org.example.model;

public class Bicycle extends Vehicle{
     public Bicycle(int id, String brand, String model){
         super(id, brand, model, 10.0);
     }

    @Override
     public double calculateCost(int hours){
         if(hours <= 0){
             throw new IllegalArgumentException("Podano nieodpowiednią liczbe godzin.");
         }

        return getHourlyRate() * hours;
     }
}
