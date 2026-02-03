package streamAPI;
import java.util.*;

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;

    Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    @Override
    public String toString() {
        return name + " - " + specialty;
    }
}

public class DoctorAvailability {
    public static void main(String[] args) {

        List<Doctor> doctors = List.of(
                new Doctor("Dr. Steve Rogers", "Cardiology", true),
                new Doctor("Dr. Tony Stark", "Neurology", false),
                new Doctor("Dr. Bruce Banner", "Orthopedics", true),
                new Doctor("Dr. Natasha Romanoff", "Dermatology", true),
                new Doctor("Dr. Pepper Potts", "Pediatrics", false)
        );

        doctors.stream().filter(d -> d.availableOnWeekend).sorted(Comparator.comparing(d -> d.specialty)).forEach(System.out::println);
    }
}
