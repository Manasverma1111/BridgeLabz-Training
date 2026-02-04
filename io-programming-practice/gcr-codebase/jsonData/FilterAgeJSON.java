import java.nio.file.Files;
import java.nio.file.Paths;

public class FilterAgeJSON {

    public static void main(String[] args) throws Exception {

        String json = new String(Files.readAllBytes(Paths.get("C:\\BridgeLab-Training\\io-programming-practice\\gcr-codebase\\jsonData\\users.json")));

        json = json.replace("[", "").replace("]", "");
        String[] users = json.split("\\},\\s*\\{");

        for (String user : users) {
            user = user.replace("{", "").replace("}", "");

            String[] fields = user.split(",");

            String name = "";
            int age = 0;

            for (String field : fields) {
                if (field.contains("\"name\"")) {
                    name = field.split(":")[1].replace("\"", "").trim();
                }
                if (field.contains("\"age\"")) {
                    age = Integer.parseInt(field.split(":")[1].trim());
                }
            }

            if (age > 25) {
                System.out.println("Name: " + name + ", Age: " + age);
            }
        }
    }
}
