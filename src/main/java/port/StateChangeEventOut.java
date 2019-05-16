package port;

import business.model.Event;

public interface StateChangeEventOut {
    void sendEvent(Event event);
}
