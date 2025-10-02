package org.example.repositories;

import org.example.models.Ticket;

import java.util.Optional;

public interface ITicketRepository {
    Ticket save(Ticket ticket);
    Optional<Ticket> findById(Long id);
}
