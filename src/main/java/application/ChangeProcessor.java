package application;

import application.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import port.ChangeEventDriverPort;
import port.StateChangeDrivenPort;

public class ChangeProcessor implements ChangeEventDriverPort {
    private static final Logger LOG = LoggerFactory.getLogger(ChangeProcessor.class);
    private StateChangeDrivenPort changeEventOut;

    public ChangeProcessor(StateChangeDrivenPort changeEventOut) {
        this.changeEventOut = changeEventOut;
    }

    @Override
    public void receiveEvent(Event event) {
        LOG.info(event.toString());
        changeEventOut.sendEvent(event);
    }

}
