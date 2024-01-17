package example.micronaut;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.sqs.Queue;
import software.constructs.Construct;

public class AppStack extends Stack {

    public AppStack(final Construct parent, final String id) {
        this(parent, id, null);
    }

    public AppStack(final Construct parent, final String id, final StackProps props) {
        super(parent, id, props);
        Queue queue = Queue.Builder.create(this, "demo_queue")
                .queueName("demo_queue")
                .build();
    }
}