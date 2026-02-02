package reflection;

import java.lang.reflect.Field;

class Users {
    String name;
    int age;
}

public class JSONReperesentation {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();

        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);

                json.append("\"")
                        .append(field.getName())
                        .append("\": \"")
                        .append(field.get(obj))
                        .append("\"");

                if (i < fields.length - 1) {
                    json.append(", ");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        Users user = new Users();
        user.name = "Steve";
        user.age = 22;

        System.out.println(JSONReperesentation.toJson(user));
    }
}
