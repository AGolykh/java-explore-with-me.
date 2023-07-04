package ru.practicum.event;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import ru.practicum.category.CategoryMapper;
import ru.practicum.event.dto.*;
import ru.practicum.event.model.Event;
import ru.practicum.location.LocationMapper;
import ru.practicum.user.UserMapper;

@Component
@Mapper(componentModel = "spring",
        uses = {CategoryMapper.class, UserMapper.class, LocationMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EventMapper  {
    Event toEvent(Long id);

    Event toEvent(EventNewDto eventNewDto);

    EventShortDto toEventShortDto(Event event);

    EventFullDto toEventFullDto(Event event);

    @Mapping(target = "state", ignore = true)
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateEvent(@MappingTarget Event event, EventAdminUpdateRequestDto eventAdminUpdateRequestDto);

    @Mapping(target = "state", ignore = true)
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateEvent(@MappingTarget Event event, EventUserUpdateRequestDto eventUserUpdateRequestDto);
}
