package java_streams;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputFromConsole {

    public static void main(String[] args) {

        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your name: ");
            String name = reader.readLine();
            System.out.print("Enter your age: ");
            String age = reader.readLine();
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            writer = new FileWriter("user_details.txt");

            writer.write("User Details\n");
            writer.write("------------\n");
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            System.out.println("\nData saved successfully to user_details.txt");

        } catch (IOException e) {
            System.out.println("An error occurred while reading input or writing to file.");
            e.printStackTrace();

        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.out.println("Error closing resources.");
            }
        }
    }
}
