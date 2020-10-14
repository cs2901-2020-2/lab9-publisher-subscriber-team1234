package lab9;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class MessageBroker {
    private static MessageBroker instance;
    private static HashMap<String, List<Subscriber>> subscribers = new HashMap<String, List<Subscriber>>();
    private static int semaphore = 0;
    private MessageBroker (){};
    public void registerSubscriber (Subscriber s, String channel) {
        subscribers.get(channel).add(s);
    }
    public void removeSubscriber (Subscriber s, String channel) {
        subscribers.get(channel).remove(s);
    }
    public static void notifySubscribers (String message, String channel) {
        subscribers.get(channel).forEach(displayMessage );
    }

    private synchronized static int increaseSemaphore () {
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
