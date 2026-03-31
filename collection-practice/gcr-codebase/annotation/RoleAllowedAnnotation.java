package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface RoleAllowed {
    String value();
}

class UserContext {
    private static String currentRole;

    public static void setRole(String role) {
        currentRole = role;
    }

    public static String getRole() {
        return currentRole;
    }
}

@RoleAllowed("ADMIN")
class AdminService {

    public void deleteUser() {
        System.out.println("User deleted successfully");
    }
}

public class RoleAllowedAnnotation {

    public static void main(String[] args) throws Exception {

        UserContext.setRole("USER");

        AdminService service = new AdminService();
        Class<?> clazz = service.getClass();

        if (clazz.isAnnotationPresent(RoleAllowed.class)) {

            RoleAllowed roleAllowed = clazz.getAnnotation(RoleAllowed.class);
            String requiredRole = roleAllowed.value();
            String currentRole = UserContext.getRole();

            if (requiredRole.equals(currentRole)) {

                Method method = clazz.getMethod("deleteUser");
                method.invoke(service);

            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}
