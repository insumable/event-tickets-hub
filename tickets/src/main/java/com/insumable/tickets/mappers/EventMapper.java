package com.insumable.tickets.mappers;

import com.insumable.tickets.domain.requests.CreateEventRequest;
import com.insumable.tickets.domain.requests.CreateTicketTypeRequest;
import com.insumable.tickets.domain.requests.UpdateEventRequest;
import com.insumable.tickets.domain.requests.UpdateTicketTypeRequest;
import com.insumable.tickets.domain.dtos.CreateEventRequestDto;
import com.insumable.tickets.domain.dtos.CreateEventResponseDto;
import com.insumable.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.insumable.tickets.domain.dtos.GetEventDetailsResponseDto;
import com.insumable.tickets.domain.dtos.GetEventDetailsTicketTypesResponseDto;
import com.insumable.tickets.domain.dtos.GetPublishedEventDetailsResponseDto;
import com.insumable.tickets.domain.dtos.GetPublishedEventDetailsTicketTypesResponseDto;
import com.insumable.tickets.domain.dtos.ListEventResponseDto;
import com.insumable.tickets.domain.dtos.ListEventTicketTypeResponseDto;
import com.insumable.tickets.domain.dtos.ListPublishedEventResponseDto;
import com.insumable.tickets.domain.dtos.UpdateEventRequestDto;
import com.insumable.tickets.domain.dtos.UpdateEventResponseDto;
import com.insumable.tickets.domain.dtos.UpdateTicketTypeRequestDto;
import com.insumable.tickets.domain.dtos.UpdateTicketTypeResponseDto;
import com.insumable.tickets.domain.entities.Event;
import com.insumable.tickets.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);

    ListEventTicketTypeResponseDto toDto(TicketType ticketType);

    ListEventResponseDto toListEventResponseDto(Event event);

    GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(
            TicketType ticketType);

    GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

    UpdateTicketTypeRequest fromDto(UpdateTicketTypeRequestDto dto);

    UpdateEventRequest fromDto(UpdateEventRequestDto dto);

    UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType);

    UpdateEventResponseDto toUpdateEventResponseDto(Event event);

    ListPublishedEventResponseDto toListPublishedEventResponseDto(Event event);

    GetPublishedEventDetailsTicketTypesResponseDto toGetPublishedEventDetailsTicketTypesResponseDto(
            TicketType ticketType);

    GetPublishedEventDetailsResponseDto toGetPublishedEventDetailsResponseDto(Event event);
}