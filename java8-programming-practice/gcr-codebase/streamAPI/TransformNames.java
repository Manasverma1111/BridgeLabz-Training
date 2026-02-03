package streamAPI;

import java.util.List;

public class TransformNames {

    public static void main(String[] args) {

        List<String> names = List.of("Charlie", "Steve", "david", "Tony", "natasha", "Pepper");

        names.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
    }

}
