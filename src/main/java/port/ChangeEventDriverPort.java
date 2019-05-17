package port;

import application.domain.Event;

public interface ChangeEventDriverPort {
    void receiveEvent(Event event);
}
