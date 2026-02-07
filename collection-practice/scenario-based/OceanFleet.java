import java.util.*;

class Vessel {
    String vesselId;
    String vesselName;
    double averageSpeed;
    String vesselType;

    Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }
}

class VesselUtil {
    List<Vessel> vesselList = new ArrayList<>();

    void addVesselPerformance(Vessel v) {
        vesselList.add(v);
    }

    Vessel getVesselById(String vesselId) {
        for (Vessel v : vesselList) {
            if (v.vesselId.equals(vesselId)) {
                return v;
            }
        }
        return null;
    }

    List<Vessel> getHighPerformanceVessels() {
        List<Vessel> result = new ArrayList<>();
        double max = 0;

        for (Vessel v : vesselList) {
            if (v.averageSpeed > max) {
                max = v.averageSpeed;
            }
        }

        for (Vessel v : vesselList) {
            if (v.averageSpeed == max) {
                result.add(v);
            }
        }
        return result;
    }
}

public class OceanFleet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VesselUtil util = new VesselUtil();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split(":");
            util.addVesselPerformance(
                    new Vessel(data[0], data[1],
                            Double.parseDouble(data[2]), data[3]));
        }

        String searchId = sc.nextLine();
        Vessel v = util.getVesselById(searchId);

        if (v != null) {
            System.out.println(v.vesselId + " | " + v.vesselName + " | "
                    + v.vesselType + " | " + v.averageSpeed + " knots");
        } else {
            System.out.println("Vessel Id " + searchId + " not found");
        }

        for (Vessel hv : util.getHighPerformanceVessels()) {
            System.out.println(hv.vesselId + " | " + hv.vesselName + " | "
                    + hv.vesselType + " | " + hv.averageSpeed + " knots");
        }
    }
}
