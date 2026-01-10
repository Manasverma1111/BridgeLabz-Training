import java.util.Scanner;

public class NumberOf1Bits {

    public static int hammingWeight(int n) {

        int count = 0;
        while (n != 0) {
            n = n & (n -1);
            count++;
            n /= 2;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a number to count number of 1 bits: ");
        int num = sc.nextInt();

        int bitCount = hammingWeight(num);
        System.out.println(bitCount);
    }
}
