package org.example.repository;

import org.example.domain.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {
    Optional<Campeonato> findByNome(String nome);
}
