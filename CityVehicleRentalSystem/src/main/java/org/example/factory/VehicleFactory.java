package org.example.factory;

import org.example.model.Bicycle;
import org.example.model.Car;
import org.example.model.ElectricScooter;
import org.example.model.Vehicle;

public class VehicleFactory {

    public static Vehicle createVehicle(VehicleType type, int id, String brand, String model){

        return switch (type) {
            case BICYCLE -> new Bicycle(id, brand, model);
            case CAR -> new Car(id, brand, model);
            case SCOOTER -> new ElectricScooter(id, brand, model);
            default -> throw new IllegalArgumentException("Blad utworzenia pojazdu: Podano bledny typ.");
        };
    }
}
