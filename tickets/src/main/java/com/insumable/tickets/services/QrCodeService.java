package com.insumable.tickets.services;

import com.insumable.tickets.domain.entities.QrCode;
import com.insumable.tickets.domain.entities.Ticket;
import java.util.UUID;

public interface QrCodeService {

    QrCode generateQrCode(Ticket ticket);

    byte[] getQrCodeImageForUserAndTicket(UUID userId, UUID ticketId);
}