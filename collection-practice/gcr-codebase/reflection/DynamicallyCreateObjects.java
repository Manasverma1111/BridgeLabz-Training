package reflection;

class Student {
    public Student() {
        System.out.println("Student object created");
    }

    public void display() {
        System.out.println("Hello from Student class");
    }
}

public class DynamicallyCreateObjects {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("reflection.Student");
            Object obj = cls.getDeclaredConstructor().newInstance();

            Student student = (Student) obj;
            student.display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
