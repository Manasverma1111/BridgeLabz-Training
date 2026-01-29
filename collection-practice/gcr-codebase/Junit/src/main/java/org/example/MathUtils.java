package Junit.src.main.java.org.example;

public class MathUtils {

    public static int divide(int a, int b) {

        if (b == 0){
            throw new ArithmeticException("Division by zero is not allowed");
        }

        return a / b;
    }
}
