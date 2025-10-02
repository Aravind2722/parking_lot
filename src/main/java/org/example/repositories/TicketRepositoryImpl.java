package org.example.repositories;

import org.example.models.Ticket;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class TicketRepositoryImpl implements ITicketRepository {
    private final Map<Long, Ticket> tickets = new TreeMap <>();
    private long autoIncId = 0;
    public Ticket save(Ticket ticket) {
        if (ticket.getId() == null || ticket.getId() == 0) ticket.setId(++autoIncId);
        tickets.put(ticket.getId(), ticket);
        return tickets.get(ticket.getId());
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        if (tickets.containsKey(id)) {
            return Optional.of(tickets.get(id));
        }
        return Optional.empty();
    }
}
