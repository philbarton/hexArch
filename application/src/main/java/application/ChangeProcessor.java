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
    public void receiveEvent(Event event) {
        LOG.info(event.toString());
        changeEventOut.sendEvent(event);
    }

}
