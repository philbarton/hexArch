package business;

import business.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import port.ChangeEventIn;
import port.StateChangeEventOut;

public class ChangeProcessor implements ChangeEventIn {
    private static final Logger LOG = LoggerFactory.getLogger(ChangeProcessor.class);
    private StateChangeEventOut changeEventOut;

    public ChangeProcessor(StateChangeEventOut changeEventOut) {
        this.changeEventOut = changeEventOut;
    }

    @Override
    public void receiveEvent(Event event) {
        LOG.info("Event : {}", event.getId());
        changeEventOut.sendEvent(event);
    }

}
