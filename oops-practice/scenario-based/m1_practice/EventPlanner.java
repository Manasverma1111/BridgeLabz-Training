package m1_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Event {

    protected String name;
    protected String location;
    protected String date;

    public Event(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public abstract void displayDetails();

}

class MusicFestival extends Event {

    private String headLiner;
    private String musicGenre;
    private int ticketPrice;

    public MusicFestival(String name, String location, String date, String headLiner, String musicGenre, int ticketPrice) {
        super(name, location, date);
        this.headLiner = headLiner;
        this.musicGenre = musicGenre;
        this.ticketPrice = ticketPrice;
    }

    public void displayDetails() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Headliner: " + headLiner);
        System.out.println("Music Genre: " + musicGenre);
        System.out.println("Ticket Price: " + ticketPrice);
        System.out.println();
    }
}

class FoodFestival extends Event {

    private String cuisine;
    private int numStalls;
    private int entryFee;

    public FoodFestival(String name, String location, String date, String cuisine, int numStalls, int entryFee) {
        super(name, location, date);
        this.cuisine = cuisine;
        this.numStalls = numStalls;
        this.entryFee = entryFee;
    }

    public void displayDetails() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Number of Stalls: " + numStalls);
        System.out.println("Entry Fee: " + entryFee);
        System.out.println();
    }
}

class ArtFestival extends Event {

    private String artType;
    private int numArtists;
    private int exhibitionFee;

    public ArtFestival(String name, String location, String date, String artType, int numArtists, int exhibitionFee) {
        super(name, location, date);
        this.artType = artType;
        this.numArtists = numArtists;
        this.exhibitionFee = exhibitionFee;
    }

    public void displayDetails() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Art Type: " + artType);
        System.out.println("Number of Artists: " + numArtists);
        System.out.println("Exhibition Fee: " + exhibitionFee);
        System.out.println();
    }
}

class CommandUtil {

    private static List<Event> festivalList = new ArrayList<>();

    public static void processCommand(Scanner sc) {

        while(true) {

            String input = sc.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];

            if (command.equals("EXIT")) {
                break;
            }

            if (command.equals("ADD_FESTIVAL")) {
                String type = parts[1];

                if (type.equals("MUSIC")) {
                    Event festival = new MusicFestival(
                            parts[2],
                            parts[3],
                            parts[4],
                            parts[5],
                            parts[6],
                            Integer.parseInt(parts[7])
                    );

                    festivalList.add(festival);
                } else if (type.equals("FOOD")) {
                    Event festival = new FoodFestival(
                            parts[2],
                            parts[3],
                            parts[4],
                            parts[5],
                            Integer.parseInt(parts[6]),
                            Integer.parseInt(parts[7])
                    );
                    festivalList.add(festival);
                } else if (type.equals("ART")) {
                    Event festival = new ArtFestival(
                            parts[2],
                            parts[3],
                            parts[4],
                            parts[5],
                            Integer.parseInt(parts[6]),
                            Integer.parseInt(parts[7])
                    );
                    festivalList.add(festival);
                }
            } else if (command.equals("DISPLAY_DETAILS")) {
                String name = parts[1];
                for (Event event : festivalList) {
                    if (event.getName().equals(name)) {
                        event.displayDetails();
                        break;
                    }
                }
            }
        }
    }
}
public class EventPlanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CommandUtil.processCommand(sc);
    }
}
