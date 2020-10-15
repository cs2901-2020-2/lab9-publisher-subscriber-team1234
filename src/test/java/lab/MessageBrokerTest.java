package lab;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class MessageBrokerTest {
    @Test
    public void testSubscriberSingleThread(){
        Subscriber subscriber1 = new Subscriber("sub1");
        Subscriber subscriber3 = new Subscriber("sub3");
        Publisher publisher1 = new Publisher();
        MessageBroker messageBroker = MessageBroker.getInstance();

        subscriber1.subscribe("Canal1");
        Assert.assertTrue(publisher1.publish("DataPrueba1", "Canal1"));

        Assert.assertEquals(subscriber1.getData(),"DataPrueba1");

        Assert.assertTrue(messageBroker.removeSubscriber(subscriber1, "Canal1"));

        Assert.assertTrue(publisher1.publish("DataPrueba2", "Canal1"));

        Assert.assertNotEquals(subscriber1.getData(),"DataPrueba2");

        Assert.assertFalse(publisher1.publish("DataPrueba2", "Canal10"));

        Assert.assertFalse(messageBroker.removeSubscriber(subscriber3,"Canal3"));
    }

    @Test
    public void testSubscriberMultipleSingleThread(){
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

        publisher1.publish("PruebaCanal2", "Canal2");

        Assert.assertNotEquals( subscriber1.getData(),"PruebaCanal2");
        Assert.assertNotEquals( subscriber2.getData(),"PruebaCanal2");
        Assert.assertNotEquals( subscriber3.getData(),"PruebaCanal2");
        Assert.assertEquals( subscriber4.getData(),"PruebaCanal2");
    }

    @Test
    public void testMultiplePublisher(){
        Subscriber subscriber1 = new Subscriber("sub1");

        Publisher publisher1 = new Publisher();
        Publisher publisher2 = new Publisher();
        Publisher publisher3 = new Publisher();

        subscriber1.subscribe("Canal1");

        publisher1.publish("PruebaCanal1", "Canal1");

        Assert.assertEquals( subscriber1.getData(),"PruebaCanal1");

        publisher2.publish("PruebaCanal1_V2", "Canal1");

        Assert.assertEquals( subscriber1.getData(),"PruebaCanal1_V2");

        publisher3.publish( "Canal2","PruebaFalsa");

        Assert.assertNotEquals( subscriber1.getData(),"PruebaFalsa");
    }


}
