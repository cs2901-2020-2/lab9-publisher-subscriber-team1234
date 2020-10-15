package lab9;

public class Publisher {

    String mensaje;
    String canal;

    public void publish(String mensaje, String canal) {
        MessageBroker.notifySubscribers(mensaje, canal);
    }

}
