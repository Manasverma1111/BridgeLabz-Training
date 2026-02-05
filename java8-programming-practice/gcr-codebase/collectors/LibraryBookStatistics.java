package collectors;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Books {

    String title;
    String genre;
    int pages;

    public Books(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    String getGenre() {
        return genre;
    }

    int getPages() {
        return pages;
    }
}
public class LibraryBookStatistics {

    public static void main(String[] args) {

        List<Books> books = List.of(
                new Books("Java Basics", "Programming", 300),
                new Books("Spring Boot", "Programming", 500),
                new Books("History of India", "History", 400),
                new Books("World War II", "History", 350)
        );

        Map<String, IntSummaryStatistics> summaryStatisticsMap = books.stream().collect(Collectors.groupingBy(Books::getGenre, Collectors.summarizingInt(Books::getPages)));
        summaryStatisticsMap.forEach((genre, stats) -> {
            System.out.println(genre +
                    " - Total: " + stats.getSum() +
                    ", Average: " + stats.getAverage() +
                    ", Max: " + stats.getMax());
        });
    }
}


