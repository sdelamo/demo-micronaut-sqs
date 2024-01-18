package example.micronaut;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.sns.SnsClient;

@MicronautTest
class MicronautguideTest {

    @Inject
    SnsClient snsClient;

    @Test
    void testItWorks() {
        // NOOP
    }

}
