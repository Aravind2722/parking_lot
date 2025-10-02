package org.example.repositories;

import org.example.models.Bill;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public interface IBillRepository {
    Bill save(Bill bill);
    Optional<Bill> findById(Long id);
}
