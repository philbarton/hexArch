package adapter.model;

import application.domain.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.UUID;

import static adapter.model.EventSerDe.deserialise;
import static adapter.model.EventSerDe.serialise;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EventSerDeTest {

    private Event event;
    private String origin;

    @Before
    public void setUp() {
        UUID id = UUID.fromString("43f4dc59-fc95-4255-adf8-6f4ab7a35819");
        String type = "create";
        String content = "some content";

        event = Event.builder()
                .id(id)
                .type(type)
                .content(content)
                .create();
        origin = "{\"id\":\"43f4dc59-fc95-4255-adf8-6f4ab7a35819\",\"type\":\"create\",\"content\":\"some content\"}";
    }

    @Test
    public void serialiseTest() throws JsonProcessingException {
        String json = serialise(event);
        assertThat(json, is(origin));
    }

    @Test
    public void deserialiseTest() throws IOException {
        Event serDeEvent = deserialise(origin);
        assertThat(serDeEvent, is(event));
    }
}