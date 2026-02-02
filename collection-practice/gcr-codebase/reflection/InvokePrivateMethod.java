package reflection;
import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();

            Class<?> cls = calc.getClass();
            Method method = cls.getDeclaredMethod("multiply", int.class, int.class);

            method.setAccessible(true);
            int result = (int) method.invoke(calc, 5, 4);

            System.out.println("Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
