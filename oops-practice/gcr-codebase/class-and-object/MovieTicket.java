class MovieTicket {

    String movieName;
    String seatNumber;
    double price;
    boolean isBooked = false;
//    method to book ticket
    void bookTicket(String movieName, String seatNumber, double price) {

        if (!isBooked) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
            isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        } else {
            System.out.println("House full!!! sorry..... Ticket already booked");
        }
    }
//    method to display ticket details
    void displayTicketDetails() {

        if (!isBooked) {
            System.out.println("Ticket have not booked yet....");
        } else {
            System.out.println("Price: $" + price);
            System.out.println();
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }

    public static void main(String[] args) {

        MovieTicket ticket = new MovieTicket();
//        before booking
        ticket.displayTicketDetails();
//        booking attempts
        ticket.bookTicket("Dragon", "A10", 120.0);
        ticket.bookTicket("Dragon", "A10", 120.0);
        ticket.bookTicket("Dragon", "A10", 120.0);
//        final ticket details
        ticket.displayTicketDetails();
    }
}
