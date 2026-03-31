import java.util.*;

class CreatorStats {
    public String creatorName;
    public double[] weeklyLikes;

    public static List<CreatorStats> engagementBoard = new ArrayList<>();

    public CreatorStats(String creatorName, double[] weeklyLikes) {
        this.creatorName = creatorName;
        this.weeklyLikes = weeklyLikes;
    }
}

public class StreamBuzz {

    public void registerCreator(CreatorStats record) {
        CreatorStats.engagementBoard.add(record);
    }

    public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {
        Map<String, Integer> result = new LinkedHashMap<>();

        for (CreatorStats cs : records) {
            int count = 0;
            for (double likes : cs.weeklyLikes) {
                if (likes >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                result.put(cs.creatorName, count);
            }
        }
        return result;
    }

    public double calculateAverageLikes() {
        double sum = 0;
        int totalWeeks = 0;

        for (CreatorStats cs : CreatorStats.engagementBoard) {
            for (double likes : cs.weeklyLikes) {
                sum += likes;
                totalWeeks++;
            }
        }
        return totalWeeks == 0 ? 0 : sum / totalWeeks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StreamBuzz app = new StreamBuzz();

        while (true) {
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Creator Name:");
                    String name = sc.nextLine();

                    double[] likes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        likes[i] = sc.nextDouble();
                    }

                    CreatorStats cs = new CreatorStats(name, likes);
                    app.registerCreator(cs);
                    System.out.println("Creator registered successfully");
                    break;

                case 2:
                    System.out.println("Enter like threshold:");
                    double threshold = sc.nextDouble();

                    Map<String, Integer> topPosts = app.getTopPostCounts(CreatorStats.engagementBoard, threshold);

                    if (topPosts.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (Map.Entry<String, Integer> entry : topPosts.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    double avg = app.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + (int) avg);
                    break;

                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
