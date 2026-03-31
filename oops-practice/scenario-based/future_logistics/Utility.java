package future_logistics;

public class Utility {

    public static boolean validateTransportId(String id) {
        return id.matches("RTS\\d{3}[A-Z]");
    }

    public static GoodsTransport parseDetails(String input) {

        String [] data = input.split(":");

        if (!validateTransportId(data[0])) {
            System.out.println("Transport id " + data[0] + " is invalid");
            System.out.println("Enter a valid record");
            return null;
        }

        if (data[3].equalsIgnoreCase("BrickTransport")) {
            return new BrickTransport(data[0], data[1], Integer.parseInt(data[2]), Float.parseFloat(data[4]), Integer.parseInt(data[5]), Float.parseFloat(data[6]));
        }

        return new TimberTransport(data[0], data[1], Integer.parseInt(data[2]), Float.parseFloat(data[4]), Float.parseFloat(data[5]), data[6], Float.parseFloat(data[7]));
    }
}
