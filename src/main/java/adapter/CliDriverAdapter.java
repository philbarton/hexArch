package adapter;

import application.ChangeProcessor;
import application.domain.Event;

import java.io.IOException;

import static adapter.model.EventSerDe.deserialise;

/**
 * A command line driver adapter
 */
public class CliDriverAdapter {

    public static void main(String[] args) throws IOException {
        ChangeProcessor changeProcessor = new ChangeProcessor(new StdOutDrivenAdapter());

        String jsonOrigin = "{\"id\":\"43f4dc59-fc95-4255-adf8-6f4ab7a35819\",\"type\":\"create\",\"content\":\"some content\"}";

        Event event = deserialise(jsonOrigin);

        changeProcessor.receiveEvent(event);
    }
}
