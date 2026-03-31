package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class MathService {

    @CacheResult
    public int expensiveSquare(int number) {
        System.out.println("Computing square for: " + number);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return number * number;
    }
}

class CacheExecutor {

    private static final Map<String, Object> cache = new HashMap<>();

    public static Object execute(Object target, String methodName, Object... args)
            throws Exception {

        Class<?> clazz = target.getClass();
        Method method = clazz.getMethod(methodName, int.class);

        String cacheKey = methodName + "_" + args[0];

        if (method.isAnnotationPresent(CacheResult.class)) {

            if (cache.containsKey(cacheKey)) {
                System.out.println("Returning cached result for: " + args[0]);
                return cache.get(cacheKey);
            }

            Object result = method.invoke(target, args);
            cache.put(cacheKey, result);
            return result;
        }

        return method.invoke(target, args);
    }
}

public class CustomCacheResultAnnotation {

    public static void main(String[] args) throws Exception {

        MathService service = new MathService();

        // First call → computation happens
        System.out.println("Result: " + CacheExecutor.execute(service, "expensiveSquare", 5));

        // Second call with same input → cached result
        System.out.println("Result: " + CacheExecutor.execute(service, "expensiveSquare", 5));

        // Different input → computation happens again
        System.out.println("Result: " + CacheExecutor.execute(service, "expensiveSquare", 7));
    }
}
