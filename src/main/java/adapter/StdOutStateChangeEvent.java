package adapter;

import adapter.model.EventMapper;
import adapter.model.EventOrigin;
import business.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import port.StateChangeEventOut;

public class StdOutStateChangeEvent implements StateChangeEventOut {
    private static final Logger LOG = LoggerFactory.getLogger(StdOutStateChangeEvent.class);

    @Override
    public void sendEvent(Event event) {
        EventOrigin eventOrigin = EventMapper.INSTANCE.fromEventToEventOrigin(event);
        LOG.info("Event : {}", eventOrigin.getId());
    }
}
