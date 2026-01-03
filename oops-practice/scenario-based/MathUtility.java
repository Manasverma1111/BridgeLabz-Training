public class MathUtility {
//    utility class for mathematical operations
    static class MathUtil {

        // method to find Factorial
        public static long factorial(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
            }

            long result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }
//        method to check for Prime number
        public static boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
//        method to find GCD using Euclidean Algorithm
        public static int gcd(int a, int b) {
            a = Math.abs(a);
            b = Math.abs(b);

            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
//        method to find Nth Fibonacci number
        public static long fibonacci(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Fibonacci is not defined for negative numbers.");
            }

            if (n == 0) return 0;
            if (n == 1) return 1;

            long a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                long sum = a + b;
                a = b;
                b = sum;
            }
            return b;
        }
    }

    public static void main(String[] args) {
//        Factorial Test
        System.out.println("Factorial Tests:");
        System.out.println("5! = " + MathUtil.factorial(5));
        System.out.println("0! = " + MathUtil.factorial(0));
//        Prime number test
        System.out.println("\nPrime Number Tests:");
        System.out.println("Is 7 prime? " + MathUtil.isPrime(7));
        System.out.println("Is 1 prime? " + MathUtil.isPrime(1));
        System.out.println("Is -5 prime? " + MathUtil.isPrime(-5));
//        GCD Test
        System.out.println("\nGCD Tests:");
        System.out.println("GCD of 54 and 24 = " + MathUtil.gcd(54, 24));
        System.out.println("GCD of -10 and 5 = " + MathUtil.gcd(-10, 5));
        System.out.println("GCD of 0 and 8 = " + MathUtil.gcd(0, 8));
//        Fibonacci Test
        System.out.println("\nFibonacci Tests:");
        System.out.println("Fibonacci(0) = " + MathUtil.fibonacci(0));
        System.out.println("Fibonacci(1) = " + MathUtil.fibonacci(1));
        System.out.println("Fibonacci(10) = " + MathUtil.fibonacci(10));
    }
}
