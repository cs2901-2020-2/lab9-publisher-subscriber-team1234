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
        logger.info (message);
    }
}
