package dev.isroy;

import dev.isroy.parking.DisplayType;
import dev.isroy.parking.ParkingLotSystem;
import dev.isroy.parking.parkinglot.ParkingSlot;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Client {

    public static void main(String[] a) {
	// write your code here
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        BufferedInputStream inputStream = new BufferedInputStream(System.in);
        Scanner in = new Scanner(inputStream);
        while(true){
            String line = in.nextLine();
            String[] args = line.split(" ");
            switch(args[0]){
                case "create_parking_lot":
                    parkingLotSystem.createParkingLot(args[1],Integer.parseInt(args[2]), Integer.parseInt(args[3]));
                    break;
                case "display":
                    parkingLotSystem.display(args[1],args[2]);
                    break;
                case "park_vehicle":
                    parkingLotSystem.parkVehicle(args[1],args[2],args[3]);
                    break;
                case "unpark_vehicle":
                    parkingLotSystem.unparkVehicle(args[1]);
                    break;
                case "exit":
                    System.exit(0);
            }
        }
    }

}
