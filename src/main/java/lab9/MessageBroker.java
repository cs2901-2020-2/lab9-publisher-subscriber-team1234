package lab9;
import java.util.HashMap;
import java.util.List;

public class MessageBroker {
    private static MessageBroker instance;
    private HashMap<String, List<Subscriber>> subscribers = new HashMap<>();
    private static int semaphore = 0;
    private MessageBroker (){};


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
