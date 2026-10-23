package org.example.service;

import org.example.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private final List<Vehicle> vehiclesList = new ArrayList<>();

    // Method to add new vehicle to list
    public void addVehicle(Vehicle vehicle){
        // Prevent adding vehicle with existing ID
        for(Vehicle existVehicle : vehiclesList){
            if(existVehicle.getId() == vehicle.getId()){
                throw new IllegalArgumentException("Pojazd o podanym id juz istnieje");
            }
        }

        vehiclesList.add(vehicle);
    }

    // Method returning list of vehicles with available = true
    public List<Vehicle> getAvailableVehicles(){
        List<Vehicle> availableVehicles = new ArrayList<>();

        // Adding to new list
        for(Vehicle vehicle : vehiclesList){
            if(vehicle.isAvailable()) availableVehicles.add(vehicle);
        }

        return availableVehicles;
    }

    // Method searching for vehicle by id returning object or throwing exception
    private Vehicle findVehicleById(int id){
        // Searching by id
        for(Vehicle vehicle : vehiclesList){
            if(vehicle.getId() == id) return vehicle;
        }

        // If it hasn't found vehicle with that id throw error
        throw new IllegalArgumentException("Nie znaleziono pojazdu o ID: " + id);
    }

    // Renting via searching, calculating cost and changing availability
    public double rentVehicle(int id, int hours){
        // Find vehicle in vehicle list
        Vehicle toRentVehicle = findVehicleById(id);

        // Calculate cost of renting
        double rentCost = toRentVehicle.calculateCost(hours);

        // Change vehicle available status to false
        toRentVehicle.rent();

        return rentCost;
    }

    // Method to return vehicle with given id
    public void returnVehicle(int id){
        Vehicle searchedVehicle = findVehicleById(id);

        searchedVehicle.returnVehicle();    // returnVehicle() from class like Car, Bicycle, ElectricScooter
    }

}
