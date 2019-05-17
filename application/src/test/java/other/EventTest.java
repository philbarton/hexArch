package other;

import application.domain.Event;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EventTest {

    @Test
    public void buildsFromBuilder() {
        UUID id = UUID.randomUUID();
        String type = "create";
        String content = "some content";

        Event event = Event.builder()
                .id(id)
                .type(type)
                .content(content)
                .create();

        assertThat(event.getId(), is(id));
        assertThat(event.getType(), is(type));
        assertThat(event.getContent(), is(content));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsValidation() {
        UUID id = UUID.randomUUID();
        String type = "bad";

        Event.builder()
                .id(id)
                .type(type)
                .create();

    }
}