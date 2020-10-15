package lab;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class MultithreadMessageBrokerTest {

    @Test(threadPoolSize = 500, invocationCount = 500)
    public void testSubscriberMultiThread(){
        Subscriber subscriber1 = new Subscriber("sub1");
        Publisher publisher1 = new Publisher();
        MessageBroker messageBroker = MessageBroker.getInstance();

        subscriber1.subscribe("Canal1");
        publisher1.publish("DataPrueba1", "Canal1");

        Assert.assertEquals(subscriber1.getData(),"DataPrueba1");

        messageBroker.removeSubscriber(subscriber1, "Canal1");
        publisher1.publish("DataPrueba2", "Canal1");

        Assert.assertNotEquals(subscriber1.getData(),"DataPrueba2");
    }

    @Test(threadPoolSize = 500, invocationCount = 500)
    public void testSubscriberMultipleMultiThread(){
        Subscriber subscriber1 = new Subscriber("sub1");
        Subscriber subscriber2 = new Subscriber("sub2");
        Subscriber subscriber3 = new Subscriber("sub3");
        Subscriber subscriber4 = new Subscriber("sub4");

        Publisher publisher1 = new Publisher();

        subscriber1.subscribe("Canal1");
        subscriber2.subscribe("Canal1");
        subscriber3.subscribe("Canal1");
        subscriber4.subscribe("Canal2");

        publisher1.publish("PruebaCanal1", "Canal1");
        Assert.assertEquals( subscriber1.getData(),"PruebaCanal1");
        Assert.assertEquals( subscriber2.getData(),"PruebaCanal1");
        Assert.assertEquals( subscriber3.getData(),"PruebaCanal1");
        Assert.assertNotEquals( subscriber4.getData(),"PruebaCanal1");

        publisher1.publish("PruebaCanal1", "Canal2");

        Assert.assertNotEquals( subscriber1.getData(),"PruebaCanal1");
        Assert.assertNotEquals( subscriber2.getData(),"PruebaCanal1");
        Assert.assertNotEquals( subscriber3.getData(),"PruebaCanal1");
        Assert.assertEquals( subscriber4.getData(),"PruebaCanal1");
    }
}
