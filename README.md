# Publisher-Subscriber Design Pattern
> The publisher-subscriber is a messaging pattern where subscribers opt in or out of a message feed. All the available feeds are managed by a message broker that acts as an intermediary between the publishers and the subscribers.
```java
public class MessageBroker {
    public void registerSubscriber(Subscriber s, String channel);
    public void removeSubscriber(Subscriber s, String channel);
    public void notifySubscribers(String channel);
}

public class Publisher {
    public void publish(Object data, String channel);
}

public class Subscriber {
    public void subscribe(String channel);
}
```

## Code Up Close

- The message broker saves lists of subscribers identified by a channel name.
- Whenever a publisher posts something to a channel, every subscriber gets notified.
- The message broker class takes advantage of the singleton pattern to guarantee all messages go through the same broker instance.

## TODO:
- Create a ```Publisher``` class that sends messages to a message broker with a specific topic.
- Create a ```Subscriber``` class that subscribes to topics from the message broker and recieves messages.
- Create a ```Message Broker``` class that manages all subscription lists and forwards messages from publishers to subscribers.

## Tests :
- Create a ```MessageBrokerTest``` class to test the broker class.
- Create a ```MultithreadMessageBrokerTest``` class to test concurrent subscribers and publishers.

  