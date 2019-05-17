package adapter;

import application.domain.Event;
import application.port.ChangeEventDriverPort;
import application.port.UnableToReceiveException;
import configure.DaggerAppComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;

import static adapter.model.EventSerDe.deserialise;

/**
 * A command line driver adapter example
 */
public class CliDriverAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(StdOutDrivenAdapter.class);
    private ChangeEventDriverPort eventDriverPort;

    @Inject
    public CliDriverAdapter(ChangeEventDriverPort stateChangeDrivenPort) {
        eventDriverPort = stateChangeDrivenPort;
    }

    @SuppressWarnings("WeakerAccess")
    public void run() {
        try {

            String jsonOrigin = "{\"id\":\"43f4dc59-fc95-4255-adf8-6f4ab7a35819\",\"type\":\"create\",\"content\":\"some content\"}";

            Event event = deserialise(jsonOrigin);

            eventDriverPort.receiveEvent(event);

        } catch (UnableToReceiveException | IllegalArgumentException | IOException e) {
            LOG.error(e.getMessage());
        }
    }

    public static void main(String[] args) {
        CliDriverAdapter driverAdapter = DaggerAppComponent.builder().build().getCliDriverAdapter();
        driverAdapter.run();
    }
}
