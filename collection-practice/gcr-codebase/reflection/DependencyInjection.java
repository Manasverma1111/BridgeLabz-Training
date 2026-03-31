package reflection;

import java.lang.reflect.Field;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {
}

class ServiceA {
    void work() {
        System.out.println("Service A working");
    }
}

class ServiceB {
    @Inject
    private ServiceA serviceA;

    void execute() {
        serviceA.work();
    }
}

public class DependencyInjection {

    public static <T> T create(Class<T> clazz) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);
                    Object dependency = field.getType()
                            .getDeclaredConstructor()
                            .newInstance();
                    field.set(obj, dependency);
                }
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        ServiceB service = DependencyInjection.create(ServiceB.class);
        service.execute();

    }
}
