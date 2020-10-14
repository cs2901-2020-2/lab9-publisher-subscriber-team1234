package lab9;

import java.util.ArrayList;
import java.util.List;

public class Subscriber {
    public void subscribe(String channel){
        suscribers.getInstance().registerSubcriber(this,channel);
    }
}
