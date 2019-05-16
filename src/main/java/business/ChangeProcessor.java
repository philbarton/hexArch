package business;

import adapter.StdOutStateChangeEvent;
import business.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import port.ChangeEventIn;

public class ChangeProcessor implements ChangeEventIn {
    private static final Logger LOG = LoggerFactory.getLogger(ChangeProcessor.class);
    private StdOutStateChangeEvent stdOutStateChangeEvent;

    public ChangeProcessor(StdOutStateChangeEvent stdOutStateChangeEvent) {
        this.stdOutStateChangeEvent = stdOutStateChangeEvent;
    }

    @Override
    public void receiveEvent(Event event) {
        LOG.info("Event : {}", event.getId());
        stdOutStateChangeEvent.sendEvent(event);
    }

}
