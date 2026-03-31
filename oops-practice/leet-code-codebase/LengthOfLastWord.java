import java.util.Scanner;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();

        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length > 0) {
                break;
            }
        }
        return length;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        LengthOfLastWord length = new LengthOfLastWord();
        int res = length.lengthOfLastWord(str);

        System.out.println(res);

    }
}
