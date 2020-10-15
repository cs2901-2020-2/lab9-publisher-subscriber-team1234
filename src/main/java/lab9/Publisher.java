package lab9;

public class Publisher {

    public void publish(String message, String canal) {
        MessageBroker messageBroker = MessageBroker.getInstance();
        messageBroker.notifySubscriber(message, canal);
    }

}
