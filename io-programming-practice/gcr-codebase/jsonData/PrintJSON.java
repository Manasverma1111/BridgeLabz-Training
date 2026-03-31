import java.nio.file.Files;
import java.nio.file.Paths;

public class PrintJSON {

    public static void main(String[] args) throws Exception {

        String json = new String(Files.readAllBytes(Paths.get("C:\\BridgeLab-Training\\io-programming-practice\\gcr-codebase\\jsonData\\data.json")));

        json = json.replace("{", "").replace("}", "").trim();
        String[] pairs = json.split(",");

        for (String pair : pairs) {
            String[] kv = pair.split(":");
            System.out.println(kv[0].replace("\"", "").trim()
                    + " : " + kv[1].replace("\"", "").trim());
        }
    }
}
