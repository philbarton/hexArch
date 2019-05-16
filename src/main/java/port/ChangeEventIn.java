package port;

import business.model.Event;

public interface ChangeEventIn {
    void receiveEvent(Event event);
}
