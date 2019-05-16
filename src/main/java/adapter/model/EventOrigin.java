package adapter.model;

import java.util.UUID;

@SuppressWarnings("WeakerAccess")
public class EventOrigin {
    private UUID id;
    private String type;
    private String content;

    public EventOrigin() {
    }

    public EventOrigin(UUID id, String type, String content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
