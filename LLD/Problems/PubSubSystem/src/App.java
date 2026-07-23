import LLD.Problems.PubSubSystem.interfaces.AlertSubscriber;
import LLD.Problems.PubSubSystem.interfaces.ISubscriber;
import LLD.Problems.PubSubSystem.interfaces.NewsSubscriber;
import LLD.Problems.PubSubSystem.models.Message;
import LLD.Problems.PubSubSystem.models.PubSubSystem;
import LLD.Problems.PubSubSystem.models.Publisher;

public class App {
    public static void main(String[] args) throws Exception {
        PubSubSystem pubSubSytem = PubSubSystem.getInstance();

        Publisher pub1 = new Publisher("gurt-1");
        Publisher pub2 = new Publisher("gurt-2");

        pubSubSytem.addPublisher(pub1);
        pubSubSytem.addPublisher(pub2);

        ISubscriber sub1 = new AlertSubscriber();
        ISubscriber sub2 = new NewsSubscriber();
        ISubscriber sub3 = new AlertSubscriber();

        int id1 = pubSubSytem.createTopic("LLD");
        int id2 = pubSubSytem.createTopic("HLD");

        pubSubSytem.subscribe(id1, sub1);
        pubSubSytem.subscribe(id2, sub2);
        pubSubSytem.subscribe(id2, sub3);

        Message msg1 = pubSubSytem.createMessage("Strategy pattern", pub1.getId(), id1);
        Message msg2 = pubSubSytem.createMessage("S3 Bucket", pub2.getId(), id2);

        pubSubSytem.publish(msg1);
        pubSubSytem.publish(msg2);

        pubSubSytem.unsubscribe(id2, sub3);
        pubSubSytem.publish(msg2);
        
    }
}
