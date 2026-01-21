package generics;
import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    abstract String getRoleName();
}

class SoftwareEngineer extends JobRole {
    @Override
    String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    @Override
    String getRoleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    @Override
    String getRoleName() {
        return "Product Manager";
    }
}

class Resume<T extends JobRole> {

    private String candidateName;
    private T role;

    public Resume(String candidateName, T role) {
        this.candidateName = candidateName;
        this.role = role;
    }

    public T getRole() {
        return role;
    }

    @Override
    public String toString() {
        return candidateName + " applying for " + role.getRoleName();
    }
}

public class ResumeScreeningSystem {

    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        System.out.println("Screening resume: " + resume);
    }

    public static void processRoles(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Processing role: " + role.getRoleName());
        }
    }

    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> r2 = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> r3 = new Resume<>("Charlie", new ProductManager());

        screenResume(r1);
        screenResume(r2);
        screenResume(r3);

        List<JobRole> roles = new ArrayList<>();
        roles.add(new SoftwareEngineer());
        roles.add(new DataScientist());
        roles.add(new ProductManager());
        processRoles(roles);
    }
}

