package reflection;
import java.lang.reflect.Field;

class Person {
    private int age = 20;
}

public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            Person p = new Person();

            Class<?> cls = p.getClass();
            Field field = cls.getDeclaredField("age");

            field.setAccessible(true);
            field.set(p, 30);

            int ageValue = (int) field.get(p);
            System.out.println("Updated Age: " + ageValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

