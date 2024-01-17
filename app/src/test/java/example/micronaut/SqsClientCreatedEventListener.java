package example.micronaut;

import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;
import jakarta.inject.Singleton;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;

@Singleton
public class SqsClientCreatedEventListener implements BeanCreatedEventListener<SqsClient> {
    private static final String QUEUE_NAME = "demo_queue";
    @Override
    public SqsClient onCreated(BeanCreatedEvent<SqsClient> event) {
        SqsClient client = event.getBean();
        if (client.listQueues().queueUrls().stream().noneMatch(it -> it.contains(QUEUE_NAME))) {
            client.createQueue(
                CreateQueueRequest.builder()
                    .queueName(QUEUE_NAME)
                    .build()
            );
        }
        return client;
    }
}
