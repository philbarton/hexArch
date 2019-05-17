package adapter.model;

import application.domain.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class EventSerDe {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String serialise(Event event) throws JsonProcessingException {
        EventOrigin origin = EventMapper.INSTANCE.fromEventToEventOrigin(event);
        return objectMapper.writeValueAsString(origin);
    }

    public static Event deserialise(String json) throws IOException {
        EventOrigin origin = objectMapper.readValue(json, EventOrigin.class);
        return EventMapper.INSTANCE.fromEventOriginToEvent(origin);
    }
}
