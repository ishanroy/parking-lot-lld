package dev.isroy.parking;

import dev.isroy.parking.parkinglot.ParkingLot;
import dev.isroy.parking.strategy.DefaultStrategy;
import dev.isroy.parking.ticket.Ticket;
import dev.isroy.parking.vehicle.Vehicle;
import dev.isroy.parking.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotSystem {
    ParkingLot parkingLot;
    Map<String,Ticket> ticketRegistry;

    public ParkingLotSystem() {
        this.ticketRegistry = new HashMap<>();
    }

    public void createParkingLot(String id, int floors, int slots){
        this.parkingLot =  new ParkingLot(id,floors,slots,new DefaultStrategy());
        System.out.printf("Created parking lot with %s floors and %s slots per floor\n",floors,slots);
    }

    public void parkVehicle(String vehicleType, String redgNo, String color){
        Ticket ticket  = this.parkingLot.parkVehicle(new Vehicle(redgNo,color, VehicleType.valueOf(vehicleType)));
        if(ticket == null)
            System.out.println("Parking Lot Full");
        else {
            ticketRegistry.put(ticket.getTicketId(), ticket);
            System.out.printf("Parked vehicle. Ticket ID: %s\n", ticket.getTicketId());
        }
    }

    public void unparkVehicle(String ticketId){
        if(!ticketRegistry.containsKey(ticketId))
            System.out.println("Invalid Ticket");
        else{
            Ticket ticket = ticketRegistry.get(ticketId);
            parkingLot.unparkVehicle(ticket);
            Vehicle vehicle = ticket.getVehicle();
            System.out.printf("Unparked vehicle with Registration Number: %s and Color: %s\n",vehicle.getRegNo(),vehicle.getColor());
            ticketRegistry.remove(ticketId);
        }
    }

    public void display(String displayType, String vehicleType){
        switch(DisplayType.valueOf(displayType)){
            case free_count:
                parkingLot.displayFreeCount(VehicleType.valueOf(vehicleType));
                break;
            case free_slots:
                parkingLot.displayFreeSlots(VehicleType.valueOf(vehicleType));
                break;
            case occupied_slots:
                parkingLot.displayOccupiedSlots(VehicleType.valueOf(vehicleType));
                break;
        }
    }

}
