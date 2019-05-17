package application.port;

import application.domain.Event;

public interface StateChangeDrivenPort {
    void sendEvent(Event event);
}
