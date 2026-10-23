package org.example;


import org.example.model.Bicycle;
import org.example.model.Car;
import org.example.model.ElectricScooter;
import org.example.model.Vehicle;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Vehicle bicycle = new Bicycle(1, "Romet", "Orkan");
        Vehicle scooter = new ElectricScooter(2, "Kukurin", "G20");
        Vehicle car = new Car(3, "Toyota", "Corolla");

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(bicycle);
        vehicles.add(scooter);
        vehicles.add(car);

        for(Vehicle vehicle : vehicles){
            System.out.println("Koszt wypozyczenia " + vehicle.getBrand() + " " + vehicle.getModel() + " to: " + vehicle.calculateCost(4));
        }

    }
}