import java.util.Stack;
import java.util.Scanner;

class validParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to validate:");
        String input = scanner.nextLine();

        validParenthesis solution = new validParenthesis();
        boolean result = solution.isValid(input);

        if (result) {
            System.out.println("The string is valid.");
        } else {
            System.out.println("The string is not valid.");
        }

        scanner.close();
    }
}

