package lab9;

public class Subscriber {
    private String name;
    private String data;

    public Subscriber(String nameTo){
        name = nameTo;
    }

    public void displayMessage(){

    }

    public void subscribe(String channel){
        MessageBroker messageBroker = MessageBroker.getInstance();
        messageBroker.registerSubscriber(this, channel);
    }

    public String getData(){
        return data;
    }
}
