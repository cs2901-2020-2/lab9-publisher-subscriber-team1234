package lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class Subscriber {
    static final Logger logger = Logger.getLogger(Subscriber.class.getName());

    public Subscriber(){};

    public void subscribe(String channel){
        MessageBroker.getInstance().registerSubscriber(this,channel);
    }

    public void displayMessage (String message) {
        logger.info(message);
    }
    private String name;
    private String data;

    public Subscriber(String nameTo){
        name = nameTo;
    }

    public void displayMessage(){

    }

    public void setData(String dataTo){
        data = dataTo;
    }

    public String getData(){
        return data;
    }
}
