package adapter.model;

import java.util.UUID;

/**
 * This class is solely used to convert json into a simple POJO, using Jackson.
 */
@SuppressWarnings("WeakerAccess")
public class EventOrigin {
    public UUID id;
    public String type;
    public String content;
}
