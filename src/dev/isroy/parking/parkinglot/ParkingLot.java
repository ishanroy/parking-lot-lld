package dev.isroy.parking.parkinglot;

import dev.isroy.parking.strategy.ParkingStrategy;
import dev.isroy.parking.ticket.Ticket;
import dev.isroy.parking.vehicle.Vehicle;
import dev.isroy.parking.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String id;
    private List<ParkingLotFloor> parkingLotFloors;
    private ParkingStrategy parkingStrategy;

    public ParkingLot(String id, List<ParkingLotFloor> parkingLotFloors) {
        this.id = id;
        this.parkingLotFloors = parkingLotFloors;
    }

    public ParkingLot(String id, int numberOfFloors, int slotsPerFloor, ParkingStrategy strategy) {
        this.id = id;
        this.parkingLotFloors = new ArrayList<>();
        this.parkingStrategy = strategy;
        for(int i = 1 ; i <= numberOfFloors ; i++){
            parkingLotFloors.add(new ParkingLotFloor(i,slotsPerFloor));
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ParkingLotFloor> getParkingLotFloors() {
        return parkingLotFloors;
    }

    public void setParkingLotFloors(List<ParkingLotFloor> parkingLotFloors) {
        this.parkingLotFloors = parkingLotFloors;
    }

    public boolean isFull(){
        for(ParkingLotFloor floor : parkingLotFloors){
            for(ParkingSlot slot : floor.getParkingSlots()) {
                if (slot.isEmpty())
                    return false;
            }
        }
        return true;
    }

    private ParkingSlot getNextSlot(VehicleType vehicleType){
        return parkingStrategy.getNextSlot(this,vehicleType);
    }

    public Ticket parkVehicle(Vehicle vehicle){
        ParkingSlot slot = getNextSlot(vehicle.getVehicleType());
        if(slot != null){
            slot.parkVehicle(vehicle);
            return new Ticket(generateTicketId(slot),vehicle);
        }else{
            return null;
        }
    }

    public void unparkVehicle(Ticket ticket){
        ParkingSlot slot = parkingLotFloors.get(ticket.getFloor()-1).getParkingSlots().get(ticket.getSlot()-1);
        slot.unParkSlot();
    }

    private String generateTicketId(ParkingSlot slot){
        StringBuilder sb = new StringBuilder();
        sb.append(id).append("_").append(slot.getFloor()).append("_").append(slot.getSlotId());
        return sb.toString();
    }

    public void displayFreeCount(VehicleType vehicleType){
        for(ParkingLotFloor floor : parkingLotFloors){
            System.out.printf("No. of free slots for %s on Floor %s: %s\n",vehicleType.toString(),floor.getFloor(),floor.getFreeSlotsCount(vehicleType));
        }
    }

    public void displayFreeSlots(VehicleType vehicleType){
        for(ParkingLotFloor floor : parkingLotFloors){
            System.out.printf("Free slots for %s on Floor %s: %s\n",vehicleType.toString(),floor.getFloor(),floor.getFreeSlots(vehicleType).toString());
        }
    }

    public void displayOccupiedSlots(VehicleType vehicleType){
        for(ParkingLotFloor floor : parkingLotFloors){
            System.out.printf("Occupied slots for %s on Floor %s: %s\n",vehicleType.toString(),floor.getFloor(),floor.getOccupiedSlots(vehicleType).toString());
        }
    }

}
