package dev.isroy.parking.parkinglot;

import dev.isroy.parking.vehicle.Vehicle;
import dev.isroy.parking.vehicle.VehicleType;

public class ParkingSlot {
    private int slotId;
    private int floor;
    private VehicleType vehicleType;
    private Vehicle parkedVehicle;
    private boolean isEmpty;

    public ParkingSlot(int floor, int slotId, VehicleType vehicleType) {
        this.floor = floor;
        this.slotId = slotId;
        this.vehicleType = vehicleType;
        this.isEmpty = true;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void parkVehicle(Vehicle vehicle){
        this.parkedVehicle = vehicle;
        this.isEmpty = false;
    }
    public void unParkSlot(){
        this.isEmpty = true;
        this.parkedVehicle = null;
    }
}
