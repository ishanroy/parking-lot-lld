package dev.isroy.parking.parkinglot;

import dev.isroy.parking.vehicle.Vehicle;
import dev.isroy.parking.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotFloor {
    private int floor;
    private List<ParkingSlot> parkingSlots;

    public ParkingLotFloor(int floor, List<ParkingSlot> parkingSlots) {
        this.floor = floor;
        this.parkingSlots = parkingSlots;
    }

    public ParkingLotFloor(int floor, int slots) {
        this.floor = floor;
        this.parkingSlots = generateSlots(slots);
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    private List<ParkingSlot> generateSlots(int slots){
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        if(slots > 1)
            parkingSlots.add(new ParkingSlot(floor, 1, VehicleType.TRUCK ));
        if(slots > 2)
            parkingSlots.add(new ParkingSlot(floor,2, VehicleType.BIKE));
        if(slots > 3)
            parkingSlots.add(new ParkingSlot(floor, 3, VehicleType.BIKE));
        for(int i = 4; i <= slots ; i++)
            parkingSlots.add(new ParkingSlot(floor,i,VehicleType.CAR));
        return parkingSlots;
    }

    public int getFreeSlotsCount(VehicleType vehicleType){
        int freeCount = 0;
        for(ParkingSlot slot : parkingSlots){
            if(slot.getVehicleType() == vehicleType && slot.isEmpty())
                freeCount++;
        }
        return freeCount;
    }

    public int getOccupiedSlotsCount(VehicleType vehicleType){
        int count = 0;
        for(ParkingSlot slot : parkingSlots){
            if(slot.getVehicleType() == vehicleType && !slot.isEmpty())
                count++;
        }
        return count;
    }

    public List<Integer> getFreeSlots(VehicleType vehicleType){
        List<Integer> freeSlots = new ArrayList<>();
        for(ParkingSlot slot : parkingSlots){
            if(slot.getVehicleType() == vehicleType && slot.isEmpty())
                freeSlots.add(slot.getSlotId());
        }
        return freeSlots;
    }

    public List<Integer> getOccupiedSlots(VehicleType vehicleType){
        List<Integer> occupiedSlots = new ArrayList<>();
        for(ParkingSlot slot : parkingSlots){
            if(vehicleType == slot.getVehicleType() && !slot.isEmpty())
                occupiedSlots.add(slot.getSlotId());
        }
        return occupiedSlots;
    }

}
