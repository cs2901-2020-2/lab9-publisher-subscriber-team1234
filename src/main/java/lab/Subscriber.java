package lab;

import java.util.logging.Logger;

public class Subscriber {
    private String name;
    private String data;
    static final Logger logger = Logger.getLogger(Subscriber.class.getName());

    public Subscriber(String nameTo){
        name = nameTo;
    }

    public void displayMessage(){
        String log = name + " message is: " + data;
        logger.info(log);
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
