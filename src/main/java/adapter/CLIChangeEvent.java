package adapter;

import adapter.model.EventMapper;
import adapter.model.EventOrigin;
import business.ChangeProcessor;
import business.model.Event;

import java.util.UUID;

public class CLIChangeEvent {

    public static void main(String[] args) {
        UUID id = UUID.randomUUID();
        String type = "create";
        String content = "some content";

        EventOrigin origin = new EventOrigin(id, type, content);

        Event event = EventMapper.INSTANCE.fromEventOriginToEvent(origin);

        ChangeProcessor changeProcessor = new ChangeProcessor(new StdOutStateChangeEvent());

        changeProcessor.receiveEvent(event);
    }
}
