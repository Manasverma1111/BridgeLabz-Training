package observer;
import java.util.*;

public class BookNotifier {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void notifyAllObservers(String msg) {
        for(Observer o : observers) {
            o.update(msg);
        }
    }

    public static void main(String[] args) {
        BookNotifier notifier = new BookNotifier();
        notifier.addObserver(new Subscriber("Alice"));
        notifier.addObserver(new Subscriber("Bob"));

        notifier.notifyAllObservers("New book arrived!");
    }
}