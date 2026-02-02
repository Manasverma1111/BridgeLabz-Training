package reflection;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "OLD_KEY";
}


public class AccessModifyStaticFields {

    public static void main(String[] args) {
        try {
            Class<?> cls = Configuration.class;

            Field field = cls.getDeclaredField("API_KEY");
            field.setAccessible(true);

            field.set(null, "NEW_SECRET_KEY");

            String updatedValue = (String) field.get(null);
            System.out.println("Updated API_KEY: " + updatedValue);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
