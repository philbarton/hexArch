package adapter;

import business.model.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import port.StateChangeEventOut;

import static adapter.model.EventSerDe.serialise;

public class StdOutStateChangeEvent implements StateChangeEventOut {
    private static final Logger LOG = LoggerFactory.getLogger(StdOutStateChangeEvent.class);

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
