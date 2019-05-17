package adapter.model;

import application.domain.Event;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Using MapStruct to map the adapter object to the domain object.
 * MapStruct uses the target object Builder if present.
 * In this case the domain object has a validating builder pattern.
 */
@Mapper
interface EventMapper {
    EventMapper INSTANCE = Mappers.getMapper( EventMapper.class );

    Event fromEventOriginToEvent(EventOrigin eventOrigin);
    EventOrigin fromEventToEventOrigin(Event event);
}
