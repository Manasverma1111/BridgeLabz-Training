package aeroVigil;

import java.util.regex.Pattern;

public class FlightUtil {

    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
        if (!Pattern.matches("FL-[1-9][0-9]{3}", flightNumber)) {
            throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
        }
        return true;
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException {
        if (!(flightName.equalsIgnoreCase("SpiceJet") ||
                flightName.equalsIgnoreCase("Vistara") ||
                flightName.equalsIgnoreCase("IndiGo") ||
                flightName.equalsIgnoreCase("Air Arabia"))) {

            throw new InvalidFlightException("The flight name " + flightName + " is invalid");
        }
        return true;
    }

    public boolean validatePassengerCount(int passengerCount, String flightName)
            throws InvalidFlightException {

        int maxCapacity;

        switch (flightName) {
            case "SpiceJet": maxCapacity = 396; break;
            case "Vistara": maxCapacity = 615; break;
            case "IndiGo": maxCapacity = 230; break;
            case "Air Arabia": maxCapacity = 130; break;
            default:
                throw new InvalidFlightException("The flight name " + flightName + " is invalid");
        }

        if (passengerCount <= 0 || passengerCount > maxCapacity) {
            throw new InvalidFlightException(
                    "The passenger count " + passengerCount + " is invalid for " + flightName);
        }
        return true;
    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel)
            throws InvalidFlightException {

        double capacity;

        switch (flightName) {
            case "SpiceJet": capacity = 200000; break;
            case "Vistara": capacity = 300000; break;
            case "IndiGo": capacity = 250000; break;
            case "Air Arabia": capacity = 150000; break;
            default:
                throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }

        if (currentFuelLevel < 0 || currentFuelLevel > capacity) {
            throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }

        return capacity - currentFuelLevel;
    }
}

