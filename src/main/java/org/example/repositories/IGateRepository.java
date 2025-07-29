package org.example.repositories;

import org.example.models.Gate;

import java.util.Optional;

public interface IGateRepository {
    Optional<Gate> findGateById(Long gateId);
}
