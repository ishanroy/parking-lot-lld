package dev.isroy.parking.strategy;

import dev.isroy.parking.parkinglot.ParkingLot;
import dev.isroy.parking.parkinglot.ParkingLotFloor;
import dev.isroy.parking.parkinglot.ParkingSlot;
import dev.isroy.parking.vehicle.VehicleType;

public class DefaultStrategy implements ParkingStrategy{
    @Override
    public ParkingSlot getNextSlot(ParkingLot parkingLot, VehicleType vehicleType) {
        for(ParkingLotFloor floor : parkingLot.getParkingLotFloors()){
            for(ParkingSlot slot : floor.getParkingSlots())
                if(slot.getVehicleType() == vehicleType && slot.isEmpty())
                    return slot;
        }
        return null;
    }
}
