import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJSON {

    public static void main(String[] args) throws Exception {

        String json = new String(Files.readAllBytes(Paths.get("C:\\BridgeLab-Training\\io-programming-practice\\gcr-codebase\\jsonData\\user.json")));

        String name = json.split("\"name\"\\s*:\\s*\"")[1].split("\"")[0];
        String email = json.split("\"email\"\\s*:\\s*\"")[1].split("\"")[0];

        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
    }
}
