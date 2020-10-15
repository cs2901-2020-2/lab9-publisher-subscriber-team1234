package lab9;

public class Publisher {

    String mensaje;
    String canal;

    public void publish(String mensaje, String canal) {
        MessageBroker messageBroker = MessageBroker.getInstance();
        messageBroker.notifySubscriber(mensaje, canal);
    }

}
