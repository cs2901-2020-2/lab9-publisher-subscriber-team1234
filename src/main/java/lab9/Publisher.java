package lab9;

public class Publisher {

    String message;
    String canal;

    public void publish(String message, String canal) {
        MessageBroker messageBroker = MessageBroker.getInstance();
        messageBroker.notifySubscriber(message, canal);
    }

}
