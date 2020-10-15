package lab;

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

    public void setData(String dataTo){
        data = dataTo;
    }

    public String getData(){
        return data;
    }
}
