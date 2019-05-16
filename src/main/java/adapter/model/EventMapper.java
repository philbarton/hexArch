package adapter.model;

import business.model.Event;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper( EventMapper.class );

    Event fromEventOriginToEvent(EventOrigin eventOrigin);
    EventOrigin fromEventToEventOrigin(Event event);
}
