package adapter;

import adapter.model.EventMapper;
import adapter.model.EventOrigin;
import business.model.Event;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EventMapperTest {

    @Test
    public void originToEvent() {
        UUID id = UUID.randomUUID();
        String type = "create";
        String content = "some content";

        EventOrigin origin = new EventOrigin(id, type, content);

        Event event = EventMapper.INSTANCE.fromEventOriginToEvent(origin);

        assertThat(event.getId(), is(id));
        assertThat(event.getType(), is(type));
        assertThat(event.getContent(), is(content));
    }

    @Test
    public void eventToOrigin() {
        UUID id = UUID.randomUUID();
        String type = "create";
        String content = "some content";

        Event event = Event.builder()
                .id(id)
                .type(type)
                .content(content)
                .create();

        EventOrigin origin = EventMapper.INSTANCE.fromEventToEventOrigin(event);

        assertThat(origin.getId(), is(id));
        assertThat(origin.getType(), is(type));
        assertThat(origin.getContent(), is(content));
    }
}