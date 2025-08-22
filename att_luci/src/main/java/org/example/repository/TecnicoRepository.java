package org.example.repository;

import org.example.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
    Optional<Tecnico> findByNome(String nome);
}
