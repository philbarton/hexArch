package adapter.model;

import application.domain.Event;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper( EventMapper.class );

    Event fromEventOriginToEvent(EventOrigin eventOrigin);
    EventOrigin fromEventToEventOrigin(Event event);
}
