package port;

import application.domain.Event;

public interface StateChangeEventOut {
    void sendEvent(Event event);
}
