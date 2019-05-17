package application;
import application.port.*;
import application.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChangeProcessor implements ChangeEventDriverPort {
    private static final Logger LOG = LoggerFactory.getLogger(ChangeProcessor.class);
    private StateChangeDrivenPort changeEventOut;

    public ChangeProcessor(StateChangeDrivenPort changeEventOut) {
        this.changeEventOut = changeEventOut;
    }

    @Override
    public void receiveEvent(Event event) throws UnableToReceiveException {
        LOG.info(event.toString());
        try {
            changeEventOut.sendEvent(event);
        } catch (UnableToSendException e) {
            LOG.error(e.getMessage());
            throw new UnableToReceiveException(e.getMessage());
        }
    }

}
