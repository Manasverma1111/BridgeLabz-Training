package collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Students {

    String name;
    String grade;

    public Students(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    String getName() {
        return name;
    }
    String getGrade() {
        return grade;
    }

}
public class StudentResultGrouping {

    public static void main(String[] args) {

        List<Students> grades = List.of(
                new Students("Steve", "B"),
                new Students("Natasha", "A"),
                new Students("Tony", "A"),
                new Students("Bruce", "C"),
                new Students("Alice", "B")
        );

        Map<String, List<String>> groupedMap = grades.stream().collect(Collectors.groupingBy(Students::getGrade, Collectors.mapping(Students::getName, Collectors.toList())));
        System.out.println(groupedMap);
    }

}
