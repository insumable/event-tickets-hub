package com.insumable.tickets.services;


import com.insumable.tickets.domain.entities.TicketValidation;
import java.util.UUID;

public interface TicketValidationService {
    TicketValidation validateTicketByQrCode(UUID qrCodeId);
    TicketValidation validateTicketManually(UUID ticketId);
}