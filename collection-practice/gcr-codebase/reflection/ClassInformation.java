package reflection;
import java.lang.reflect.*;

public class ClassInformation {
    public static void main(String[] args) {

        try {
            String className = "java.lang.String";
            Class<?> cls = Class.forName(className);

            System.out.println("Class Name: " + cls.getName());

            System.out.println("\n--- Constructors ---");
            for (Constructor<?> c : cls.getDeclaredConstructors()) {
                System.out.println(c);
            }

            System.out.println("\nFields");
            for (Field f : cls.getDeclaredFields()) {
                System.out.println(f);
            }

            System.out.println("\nMethods");
            for (Method m : cls.getDeclaredMethods()) {
                System.out.println(m);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

