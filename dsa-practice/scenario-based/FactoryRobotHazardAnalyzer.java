import java.util.Scanner;

class RobotSafetyException extends Exception {
    public RobotSafetyException(String message) {
        super(message);
    }
}

class RobotHazardAuditor {

    public double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState) throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
        }
        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException("Error: Worker density must be 1-20");
        }

        double machineRiskFactor;

        if (machineryState.equals("Worn")) {
            machineRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineRiskFactor = 2.0;
        } else if (machineryState.equals("Critical")) {
            machineRiskFactor = 3.0;
        } else {
            throw new RobotSafetyException("Error: Unsupported machinery state");
        }

        return ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
    }
}

public class FactoryRobotHazardAnalyzer {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RobotHazardAuditor auditor = new RobotHazardAuditor();

        try {
            System.out.println("Enter Arm Precision (0.0 - 1.0):");
            double armPrecision = sc.nextDouble();

            System.out.println("Enter Worker Density (1 - 20):");
            int workerDensity = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Machinery State (Worn/Faulty/Critical):");
            String machineryState = sc.nextLine();

            double risk = auditor.calculateHazardRisk(armPrecision, workerDensity, machineryState);
            System.out.println("Robot Hazard Risk Score: " + risk);

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }
    }
}
