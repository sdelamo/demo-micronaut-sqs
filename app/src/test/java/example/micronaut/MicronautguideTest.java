package example.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class MicronautguideTest {

    @Inject
    DemoConsumer demoConsumer;

    @Test
    void testItWorks(@Client("/") HttpClient httpClient) {
        assertEquals(0, demoConsumer.getMessageCount());
        httpClient.toBlocking().exchange(HttpRequest.POST("/demo", Collections.emptyMap()));
        await().until(() -> demoConsumer.getMessageCount(), equalTo(1));
    }

}
