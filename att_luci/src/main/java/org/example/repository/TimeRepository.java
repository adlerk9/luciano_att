package org.example.repository;

import org.example.domain.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TimeRepository extends JpaRepository<Time, Long> {
    Optional<Time> findByNome(String nome);
}
