package functional_interfaces;

interface UnitConverter {

    static double kmToMiles(double km) {
        return km * 0.621371;
    }

    static double kgToLbs(double kg) {
        return kg * 2.20462;
    }
}

public class UnitConversionTool {

    public static void main(String[] args) {

        double distanceKm = 100.0;
        double weightKg = 50.0;

        System.out.println(distanceKm + " km = " + UnitConverter.kmToMiles(distanceKm) + " miles");
        System.out.println(weightKg + " kg = " + UnitConverter.kgToLbs(weightKg) + " lbs");
    }
}
