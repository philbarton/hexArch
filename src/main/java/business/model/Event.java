package business.model;

import common.ValidatingBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class Event {

    @NotNull
    private UUID id;
    @NotNull
    @Size(min = 6, max = 6)
    private String type;
    @NotNull
    @Size(min = 2, max = 30)
    private String content;

    public static Event.EventBuilder builder() {
        return new Event.EventBuilder();
    }

    private Event(Event.EventBuilder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.content = builder.content;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public static class EventBuilder extends ValidatingBuilder {
        private UUID id;
        private String type;
        private String content;

        public EventBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public EventBuilder type(String type) {
            this.type = type;
            return this;
        }

        public EventBuilder content(String content) {
            this.content = content;
            return this;
        }

        public Event create() throws IllegalArgumentException {
            return validate(new Event(this));
        }
    }
}
