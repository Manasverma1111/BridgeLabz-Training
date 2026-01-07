import java.util.Scanner;

public class ReverseString {

    public String reverseString(String str) {

        int n = str.length() - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = n; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        ReverseString revStr = new ReverseString();
        String res = revStr.reverseString(str);
        System.out.println(res);

    }
}
