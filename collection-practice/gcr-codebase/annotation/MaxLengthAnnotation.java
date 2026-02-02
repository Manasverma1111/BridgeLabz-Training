package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {

    @MaxLength(10)
    private String username;

    public User(String username) {
        validateMaxLength(username);
        this.username = username;
        System.out.println("User created with username: " + username);
    }

    private void validateMaxLength(String value) {
        try {
            Field field = this.getClass().getDeclaredField("username");

            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);

                if (value.length() > maxLength.value()) {
                    throw new IllegalArgumentException("Username length exceeds maximum allowed length of " + maxLength.value());
                }
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}

public class MaxLengthAnnotation {

    public static void main(String[] args) {

        new User("tony");
        new User("verylongusername");
    }
}
