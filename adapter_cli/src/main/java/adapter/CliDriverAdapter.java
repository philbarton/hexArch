package adapter;

import application.ChangeProcessor;
import application.domain.Event;
import application.port.ChangeEventDriverPort;

import java.io.IOException;

import static adapter.model.EventSerDe.deserialise;

/**
 * A command line driver adapter example
 */
public class CliDriverAdapter {

    public static void main(String[] args) throws IOException {
        ChangeEventDriverPort eventDriverPort = new ChangeProcessor(new StdOutDrivenAdapter());

        String jsonOrigin = "{\"id\":\"43f4dc59-fc95-4255-adf8-6f4ab7a35819\",\"type\":\"create\",\"content\":\"some content\"}";

        Event event = deserialise(jsonOrigin);

        eventDriverPort.receiveEvent(event);
    }
}
