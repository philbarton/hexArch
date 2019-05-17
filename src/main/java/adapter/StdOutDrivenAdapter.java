package adapter;

import application.domain.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import application.port.StateChangeDrivenPort;

import static adapter.model.EventSerDe.serialise;

/**
 * A standard out driven adapter example
 */
public class StdOutDrivenAdapter implements StateChangeDrivenPort {
    private static final Logger LOG = LoggerFactory.getLogger(StdOutDrivenAdapter.class);

    @Override
    public void sendEvent(Event event) {
        try {
            String json = serialise(event);
            LOG.info("Event : {}", json);
        } catch (JsonProcessingException e) {
            LOG.error(e.getMessage());
        }
    }
}
