package adapter;

import business.ChangeProcessor;
import business.model.Event;

import java.io.IOException;

import static adapter.model.EventSerDe.deserialise;

public class CLIChangeEvent {

    public static void main(String[] args) throws IOException {
        ChangeProcessor changeProcessor = new ChangeProcessor(new StdOutStateChangeEvent());

        String jsonOrigin = "{\"id\":\"43f4dc59-fc95-4255-adf8-6f4ab7a35819\",\"type\":\"create\",\"content\":\"some content\"}";

        Event event = deserialise(jsonOrigin);

        changeProcessor.receiveEvent(event);
    }
}
