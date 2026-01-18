import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String str) {

        Stack<Character> stk = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stk.push(ch);
            } else {
                if (stk.isEmpty()) {
                    return false;
                }

                char top = stk.peek();
                if ((top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']')) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }

        return stk.isEmpty();
    }

    public static void main(String[] args) {

        String str = "([]{})";
        System.out.println(isValid(str));
    }
}
