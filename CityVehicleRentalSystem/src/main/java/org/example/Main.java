package org.example;


import org.example.factory.VehicleFactory;
import org.example.factory.VehicleType;
import org.example.model.Vehicle;
import org.example.service.RentalService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vehicle bicycle = VehicleFactory.createVehicle(VehicleType.BICYCLE,1, "Romet", "Orkan");
        Vehicle scooter = VehicleFactory.createVehicle(VehicleType.SCOOTER, 2, "Kukurin", "G20");
        Vehicle car = VehicleFactory.createVehicle(VehicleType.CAR, 3, "Toyota", "Corolla");

        RentalService rentalService = new RentalService();

        rentalService.addVehicle(bicycle);
        rentalService.addVehicle(scooter);
        rentalService.addVehicle(car);

        // Display available vehicles
        displayAvailableVehicles(rentalService);

        // Rent bicycle
        double rentCost = rentalService.rentVehicle(1, 3);
        System.out.println("Oplata za wyporzyczenie: " + rentCost);

        // Exceptions test
        //  Try to add new vehicle with already existing ID
        try{
            rentalService.addVehicle(VehicleFactory.createVehicle(VehicleType.CAR,3, "Toyota", "Supra"));
        } catch (IllegalArgumentException e){
            System.out.println("Blad dodania pojazdu: " + e.getMessage());
        }

        //  Try rent already rented bicycle
        try{
            rentalService.rentVehicle(1, 4);
        } catch (IllegalStateException e){
            System.out.println("Blad wypozyczenia: " + e.getMessage());
        }

        //  Try rent non existed id
        try{
           rentalService.rentVehicle(999, 3);
        } catch (IllegalArgumentException e){
            System.out.println("Blad wypozyczenia: " + e.getMessage());
        }

        //  Try rent for 0 hours
        try{
            rentalService.rentVehicle(2, 0);
        } catch (IllegalArgumentException e){
            System.out.println("Blad wypozyczenia: " + e.getMessage());
        }

        // Display available vehicles once again
        displayAvailableVehicles(rentalService);

        // Return bicycle
        rentalService.returnVehicle(1);

        // Display available vehicles once again
        displayAvailableVehicles(rentalService);
    }

    // Method to display available vehicles from rentalService
    private static void displayAvailableVehicles(RentalService rentalService){
        List<Vehicle> availbleVehicles = rentalService.getAvailableVehicles();

        System.out.println("\tDostepne pojazdy: ");
        for(Vehicle vehicle : availbleVehicles){
            System.out.println(
                    vehicle.getId() + " | " +
                            vehicle.getBrand() + " | " +
                            vehicle.getModel()
            );
        }
    }
}

