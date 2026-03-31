package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class Users {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_email")
    private String email;

    private int age;

    public Users(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
}

class JsonSerializer {

    public static String toJson(Object obj) {

        StringBuilder json = new StringBuilder("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        boolean firstField = true;

        try {
            for (Field field : fields) {

                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true);
                    JsonField annotation = field.getAnnotation(JsonField.class);

                    if (!firstField) {
                        json.append(", ");
                    }

                    json.append("\"")
                            .append(annotation.name())
                            .append("\": \"")
                            .append(field.get(obj))
                            .append("\"");

                    firstField = false;
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        json.append("}");
        return json.toString();
    }
}

public class JsonFieldAnnotation {

    public static void main(String[] args) {

        Users user = new Users("steve", "steve@gmail.com", 22);
        String json = JsonSerializer.toJson(user);

        System.out.println(json);
    }
}
