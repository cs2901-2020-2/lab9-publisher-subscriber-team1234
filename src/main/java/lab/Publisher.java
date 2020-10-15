package lab;

public class Publisher {

    public boolean publish(String message, String canal) {
        MessageBroker messageBroker = MessageBroker.getInstance();
        return messageBroker.notifySubscriber(message, canal);
    }

}
