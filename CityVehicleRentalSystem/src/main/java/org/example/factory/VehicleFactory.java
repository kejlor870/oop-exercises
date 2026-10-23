package org.example.factory;

import org.example.model.Bicycle;
import org.example.model.Car;
import org.example.model.ElectricScooter;
import org.example.model.Vehicle;

public class VehicleFactory {

    public static Vehicle createVehicle(String type, int id, String brand, String model){

        if("bicycle".equals(type)){
            return new Bicycle(id, brand, model);
        } else if ("car".equals(type)) {
            return new Car(id, brand, model);
        } else if ("scooter".equals(type)) {
            return new ElectricScooter(id, brand, model);
        } else {
            throw new IllegalArgumentException("Blad utworzenia pojazdu: Podano bledny typ.");
        }
    }
}
