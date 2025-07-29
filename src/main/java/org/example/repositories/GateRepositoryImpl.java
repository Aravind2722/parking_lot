package org.example.repositories;


import org.example.models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepositoryImpl implements IGateRepository {
    private Map<Long, Gate> gates = new TreeMap<>();
    // using treeMap to simulate the log N time complexit of B+ tree in database
    @Override
    public Optional<Gate> findGateById(Long gateId) {
        if (gates.containsKey(gateId)) return Optional.of(gates.get(gateId));
        return Optional.empty();
    }
}
