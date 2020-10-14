package lab9;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class MessageBroker {
    private HashMap<String, List<Subscriber>> subscribers = new HashMap<String, List<Subscriber>>();
    private int semaphore = 0;
    private MessageBroker (){};
    public void registerSubscriber (Subscriber s, String channel) {
        subscribers.get(channel).add(s);
    }
    public void removeSubscriber (Subscriber s, String channel) {
        subscribers.get(channel).remove(s);
    }
    public void notifySubscriber (String message, String channel) {
        subscribers.get(channel).forEach(displayMessage );
    }



    public static MessageBroker getInstance() {

    }
}
