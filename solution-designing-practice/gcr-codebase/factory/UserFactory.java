package factory;

public class UserFactory {
    public static User createUser(String type) {
        switch(type.toLowerCase()) {
            case "student": return new Student();
            case "faculty": return new Faculty();
            case "librarian": return new Librarian();
            default: throw new IllegalArgumentException("Invalid user type");
        }
    }

    public static void main(String[] args) {
        User u1 = UserFactory.createUser("student");
        User u2 = UserFactory.createUser("faculty");
        u1.showRole();
        u2.showRole();
    }
}