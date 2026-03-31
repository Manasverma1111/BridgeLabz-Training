import java.util.*;

class InvalidRatingException extends Exception {
    public InvalidRatingException(String message) {
        super(message);
    }
}

class EventFeedback {

    private Map<String, List<Integer>> feedbackMap = new HashMap<>();

    public void addRating(String eventId, int rating) throws InvalidRatingException {
        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException("Rating must be between 1 and 5");
        }

        feedbackMap
                .computeIfAbsent(eventId, k -> new ArrayList<>())
                .add(rating);
    }

    public double getAverageRating(String eventId) {
        List<Integer> ratings = feedbackMap.get(eventId);
        if (ratings == null || ratings.isEmpty()) return 0;

        int sum = 0;
        for (int r : ratings) {
            sum += r;
        }
        return (double) sum / ratings.size();
    }

    public void printTopRatedEvent() {
        double maxAvg = 0;
        String topEvent = null;

        for (String eventId : feedbackMap.keySet()) {
            double avg = getAverageRating(eventId);
            if (avg > maxAvg) {
                maxAvg = avg;
                topEvent = eventId;
            }
        }

        if (topEvent != null) {
            System.out.println("Top Rated Event: " + topEvent +
                    " | Average Rating: " + maxAvg);
        }
    }

    public void printAllAverages() {
        for (String eventId : feedbackMap.keySet()) {
            System.out.println(eventId + " -> Average Rating: "
                    + getAverageRating(eventId));
        }
    }
}

public class EventFeedbackAnalyzer {

    public static void main(String[] args) {

        try {
            EventFeedback feedback = new EventFeedback();

            feedback.addRating("EVT101", 5);
            feedback.addRating("EVT101", 4);
            feedback.addRating("EVT102", 3);
            feedback.addRating("EVT102", 5);
            feedback.addRating("EVT103", 4);

            feedback.printAllAverages();
            feedback.printTopRatedEvent();

        } catch (InvalidRatingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
