class HotelBooking {

    String guestName;
    String roomType;
    int nights;

    HotelBooking() {

        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    HotelBooking(String guestName, String roomType, int nights) {

        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    HotelBooking(HotelBooking other) {

        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    // Method to display booking details
    void displayBookingDetails() {

        System.out.println("Guest Name : " + guestName);
        System.out.println("Room Type  : " + roomType);
        System.out.println("Nights     : " + nights);
    }

    public static void main(String[] args) {

        // default booking
        HotelBooking booking1 = new HotelBooking();
        // parameterized booking
        HotelBooking booking2 = new HotelBooking("Natasha Romanoff", "Deluxe", 3);
        // Copy booking
        HotelBooking booking3 = new HotelBooking(booking2);

        booking1.displayBookingDetails();
        System.out.println();
        booking2.displayBookingDetails();
        System.out.println();
        booking3.displayBookingDetails();
    }
}
