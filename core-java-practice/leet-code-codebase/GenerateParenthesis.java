import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        recurse(result, 0, 0, "", n);
        return result;
    }

    private void recurse(List<String> result, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            result.add(s);
            return;
        }
        if (left < n) {
            recurse(result, left + 1, right, s + "(", n);
        }
        if (right < left) {
            recurse(result, left, right + 1, s + ")", n);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of pairs of parentheses:");
        int n = scanner.nextInt();

        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> result = gp.generateParenthesis(n);

        System.out.println("Generated Parentheses Combinations:");
        for (String s : result) {
            System.out.println(s);
        }

        scanner.close();
    }
}
