package streamAPI;

import java.util.List;

public class EmailNotification {

    static void sendEmailNotification(String email) {
        System.out.println("Notification sent to: " + email);
    }

    public static void main(String[] args) {

        List<String> emails = List.of("tony@gmail.com", "pepper35@gmail.com", "bruce123@gmail.com");

        emails.forEach(EmailNotification::sendEmailNotification);
    }
}
