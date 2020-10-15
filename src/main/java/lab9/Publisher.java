package lab9;

public class Publisher {
    String mensaje;
    String canal;

    public void publish(String message, String canal) {
        MessageBroker messageBroker = MessageBroker.getInstance();
        messageBroker.notifySubscribers(message, canal);
    }

}
