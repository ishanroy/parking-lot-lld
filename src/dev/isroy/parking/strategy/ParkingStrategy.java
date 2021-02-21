package dev.isroy.parking.strategy;

import dev.isroy.parking.parkinglot.ParkingLot;
import dev.isroy.parking.parkinglot.ParkingSlot;
import dev.isroy.parking.vehicle.VehicleType;

public interface ParkingStrategy {
    public ParkingSlot getNextSlot(ParkingLot parkingLot, VehicleType vehicleType);
}
