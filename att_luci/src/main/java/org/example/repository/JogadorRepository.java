package org.example.repository;

import org.example.domain.Jogador;
import org.example.domain.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    Optional<Jogador> findByNome(String nome);
    List<Jogador> findByStatus(String status);
    List<Jogador> findByTime(Time time);
}
