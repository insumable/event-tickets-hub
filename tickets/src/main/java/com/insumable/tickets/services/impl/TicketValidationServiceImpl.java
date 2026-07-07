package com.insumable.tickets.services.impl;

import com.insumable.tickets.domain.entities.QrCode;
import com.insumable.tickets.domain.enums.QrCodeStatusEnum;
import com.insumable.tickets.domain.entities.Ticket;
import com.insumable.tickets.domain.entities.TicketValidation;
import com.insumable.tickets.domain.enums.TicketValidationMethod;
import com.insumable.tickets.domain.enums.TicketValidationStatusEnum;
import com.insumable.tickets.exceptions.QrCodeNotFoundException;
import com.insumable.tickets.exceptions.TicketNotFoundException;
import com.insumable.tickets.repositories.QrCodeRepository;
import com.insumable.tickets.repositories.TicketRepository;
import com.insumable.tickets.repositories.TicketValidationRepository;
import com.insumable.tickets.services.TicketValidationService;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketValidationServiceImpl implements TicketValidationService {

    private final QrCodeRepository qrCodeRepository;
    private final TicketValidationRepository ticketValidationRepository;
    private final TicketRepository ticketRepository;

    @Override
    public TicketValidation validateTicketByQrCode(UUID qrCodeId) {
        QrCode qrCode = qrCodeRepository.findByIdAndStatus(qrCodeId, QrCodeStatusEnum.ACTIVE)
                .orElseThrow(() -> new QrCodeNotFoundException(
                        String.format(
                                "QR Code with ID %s was not found", qrCodeId
                        )
                ));

        Ticket ticket = qrCode.getTicket();

        return validateTicket(ticket, TicketValidationMethod.QR_SCAN);
    }

    private TicketValidation validateTicket(Ticket ticket,
                                            TicketValidationMethod ticketValidationMethod) {
        TicketValidation ticketValidation = new TicketValidation();
        ticketValidation.setTicket(ticket);
        ticketValidation.setValidationMethod(ticketValidationMethod);

        TicketValidationStatusEnum ticketValidationStatus = ticket.getValidations().stream()
                .filter(v -> TicketValidationStatusEnum.VALID.equals(v.getStatus()))
                .findFirst()
                .map(v -> TicketValidationStatusEnum.INVALID)
                .orElse(TicketValidationStatusEnum.VALID);

        ticketValidation.setStatus(ticketValidationStatus);

        return ticketValidationRepository.save(ticketValidation);
    }

    @Override
    public TicketValidation validateTicketManually(UUID ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(TicketNotFoundException::new);
        return validateTicket(ticket, TicketValidationMethod.MANUAL);
    }
}