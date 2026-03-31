import java.util.Scanner;

class ReverseStringIII {

    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder resStr = new StringBuilder();

        for (String st : str) {
            resStr.append(new StringBuilder(st).reverse()).append(" ");
        }

        return resStr.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();
        ReverseStringIII res = new ReverseStringIII();
        String result = res.reverseWords(str);

        System.out.println("Reversed string: " + result);

    }
}
