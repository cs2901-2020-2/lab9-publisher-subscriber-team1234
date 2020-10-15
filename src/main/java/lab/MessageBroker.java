package lab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MessageBroker {
    private static MessageBroker instance;
    private HashMap<String, List<Subscriber>> subscribers = new HashMap<>();
    private static int semaphore = 0;

    public synchronized void registerSubscriber (Subscriber s, String channel) {
        if (!subscribers.containsKey(channel)) {
            List<Subscriber> subs = new ArrayList<Subscriber>();
            subscribers.put(channel, subs );
        }
        subscribers.get(channel).add(s);
    }

    public synchronized boolean removeSubscriber (Subscriber s, String channel) {
        if (subscribers.containsKey(channel)) {
            subscribers.get(channel).remove(s);
            return true;
        }else return false;
    }

    public boolean notifySubscriber (String message, String channel) {
        if (subscribers.containsKey(channel)){
            for(Subscriber subs : subscribers.get(channel)){
                subs.setData(message);
                subs.displayMessage();
            }
            return true;
        }else return false;
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
