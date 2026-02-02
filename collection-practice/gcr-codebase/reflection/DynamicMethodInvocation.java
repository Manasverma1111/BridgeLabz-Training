package reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter method name (add/subtract/multiply): ");
            String methodName = sc.next();

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            Class<?> cls = MathOperations.class;
            Object obj = cls.getDeclaredConstructor().newInstance();

            Method method = cls.getMethod(methodName, int.class, int.class);
            Object result = method.invoke(obj, a, b);

            System.out.println("Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
