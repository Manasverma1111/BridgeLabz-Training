import java.util.List;

public class UppercaseNames {

    public static void main(String[] args) {

        List<String> names = List.of("Steve", "Tony", "Bruce");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
