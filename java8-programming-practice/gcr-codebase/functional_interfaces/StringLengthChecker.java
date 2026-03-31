package functional_interfaces;
import java.util.function.Function;

public class StringLengthChecker {

    public static void main(String[] args) {

        int charLimit = 20;
        Function<String, Integer> lengthFunction = String::length;

        String[] messages = {"Hello World", "This message is definitely too long"};

        for (String msg : messages) {
            int length = lengthFunction.apply(msg);

            if (length > charLimit) {
                System.out.println("Message exceeds limit (" + length + " chars): " + msg);
            } else {
                System.out.println("Message within limit (" + length + " chars): " + msg);
            }
        }
    }
}
