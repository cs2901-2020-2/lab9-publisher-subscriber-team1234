package lab;
import java.util.HashMap;
import java.util.List;

public class MessageBroker {
    private static MessageBroker instance;
    private HashMap<String, List<Subscriber>> subscribers = new HashMap<>();
    private static int semaphore = 0;

    public void registerSubscriber (Subscriber s, String channel) {
        subscribers.get(channel).add(s);
    }

    public void removeSubscriber (Subscriber s, String channel) {
        subscribers.get(channel).remove(s);
    }

    public void notifySubscriber (String message, String channel) {
        for(Subscriber subs : subscribers.get(channel)){
            subs.setData(message);
            subs.displayMessage();
        }
    }

    private static synchronized int increaseSemaphore () {
        int prev = semaphore;
        semaphore++;
        return prev;
    }

    public static MessageBroker getInstance() {
        if (increaseSemaphore () == 0)
            instance = new MessageBroker();
        return instance;
    }
}
