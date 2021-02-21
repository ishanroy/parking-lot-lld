package dev.isroy.parking.ticket;

import dev.isroy.parking.vehicle.Vehicle;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private long entryTime;
    private long exitTime;

    public Ticket(String ticketId, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.entryTime = System.currentTimeMillis();
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public String getParkingLotId(){
        String[] arr = ticketId.split("_");
        return arr[0];
    }

    public int getFloor(){
        String[] arr = ticketId.split("_");
        return Integer.parseInt(arr[1]);
    }

    public int getSlot(){
        String[] arr = ticketId.split("_");
        return Integer.parseInt(arr[2]);
    }
}
