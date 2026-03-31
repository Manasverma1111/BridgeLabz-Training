import java.util.*;

class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException(String message) {
        super(message);
    }
}

interface PricingStrategy {
    double calculatePrice(double basePrice, int days);
}

// Normal pricing
class RegularPricing implements PricingStrategy {
    public double calculatePrice(double basePrice, int days) {
        return basePrice * days;
    }
}

// Seasonal pricing (polymorphism)
class SeasonalPricing implements PricingStrategy {
    public double calculatePrice(double basePrice, int days) {
        return (basePrice * 1.2) * days; // 20% extra
    }
}

abstract class Room {
    int roomNumber;
    double basePrice;
    boolean isAvailable = true;

    Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    abstract String getType();
}

class StandardRoom extends Room {
    StandardRoom(int roomNumber) {
        super(roomNumber, 2000);
    }

    String getType() {
        return "Standard Room";
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(int roomNumber) {
        super(roomNumber, 3500);
    }

    String getType() {
        return "Deluxe Room";
    }
}

class Guest {
    String name;

    Guest(String name) {
        this.name = name;
    }
}

class Reservation {
    Guest guest;
    Room room;
    int days;
    double billAmount;

    Reservation(Guest guest, Room room, int days, PricingStrategy pricing) {
        this.guest = guest;
        this.room = room;
        this.days = days;
        this.billAmount = pricing.calculatePrice(room.basePrice, days);
    }
}

public class HotelReservationSystem {

    public static Room bookRoom(Room room, Guest guest, int days, PricingStrategy pricing)
            throws RoomNotAvailableException {

        if (!room.isAvailable) {
            throw new RoomNotAvailableException("Room not available");
        }

        room.isAvailable = false;
        Reservation reservation = new Reservation(guest, room, days, pricing);

        System.out.println("Room Booked: " + room.getType());
        System.out.println("Guest: " + guest.name);
        System.out.println("Bill: " + reservation.billAmount);

        return room;
    }

    public static void checkout(Room room) {
        room.isAvailable = true;
        System.out.println("Checked out from Room: " + room.roomNumber);
    }

    public static void main(String[] args) {

        Room standard = new StandardRoom(101);
        Room deluxe = new DeluxeRoom(201);

        Guest guest1 = new Guest("Bruce Banner");
        Guest guest2 = new Guest("Tony Stark");

        PricingStrategy pricing = new SeasonalPricing();

        try {
            bookRoom(standard, guest1, 3, pricing);
        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
        checkout(standard);
        System.out.println();

        try {
            bookRoom(deluxe, guest2,5, pricing);
        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
        checkout(deluxe);
    }
}
