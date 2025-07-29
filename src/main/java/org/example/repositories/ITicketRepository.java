package org.example.repositories;

import org.example.models.Ticket;

public interface ITicketRepository {
    Ticket save(Ticket ticket);
}
