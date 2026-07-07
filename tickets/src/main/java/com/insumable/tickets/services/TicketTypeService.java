package com.insumable.tickets.services;

import com.insumable.tickets.domain.entities.Ticket;
import java.util.UUID;

public interface TicketTypeService {
    Ticket purchaseTicket(UUID userId, UUID ticketTypeId);
}