package port;

import application.domain.Event;

public interface ChangeEventIn {
    void receiveEvent(Event event);
}
