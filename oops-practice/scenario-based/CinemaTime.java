import java.util.ArrayList;
import java.util.List;

class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}

public class CinemaTime {

    private List<String> titles = new ArrayList<>();
    private List<String> times = new ArrayList<>();

    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid showtime: " + time);
        }
        titles.add(title);
        times.add(time);
    }

    public void searchMovie(String keyword) {
        boolean found = false;

        try {
            for (int i = 0; i < titles.size(); i++) {
                if (titles.get(i).contains(keyword)) {
                    System.out.println(
                            String.format("Movie: %s | Time: %s", titles.get(i), times.get(i)));
                    found = true;
                }
            }

            if (!found) {
                throw new IndexOutOfBoundsException();
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Movie not found for : " + keyword);
        }
    }

    public void displayAllMovies() {
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(
                    String.format("%d. %s - %s", i + 1, titles.get(i), times.get(i)));
        }
    }

    public void printReport() {
        String[] titleArray = titles.toArray(new String[0]);
        String[] timeArray = times.toArray(new String[0]);

        System.out.println("\nReport:");
        for (int i = 0; i < titleArray.length; i++) {
            System.out.println(titleArray[i] + " | " + timeArray[i]);
        }
    }

    // Time validation HH:MM
    private boolean isValidTime(String time) {
        if (!time.matches("\\d{2}:\\d{2}")) {
            return false;
        }

        int h = Integer.parseInt(time.substring(0, 2));
        int m = Integer.parseInt(time.substring(3, 5));

        return h >= 0 && h <= 23 && m >= 0 && m <= 59;
    }

    public static void main(String[] args) {

        CinemaTime cinema = new CinemaTime();

        try {
            cinema.addMovie("Inception", "18:30");
            cinema.addMovie("Interstellar", "21:15");
            cinema.addMovie("Avatar", "25:99"); // invalid
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nAll Movies:");
        cinema.displayAllMovies();
        System.out.println("\nSearch:");
        cinema.searchMovie("Inter");

        cinema.printReport();
    }
}
