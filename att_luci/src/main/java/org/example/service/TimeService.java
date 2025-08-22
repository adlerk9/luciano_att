package org.example.service;

import org.example.domain.Time;
import org.example.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time criar(Time time) { return timeRepository.save(time); }

    public List<Time> listarTodos() { return timeRepository.findAll(); }

    public Time buscarPorId(Long id) { return timeRepository.findById(id).orElse(null); }

    public Time atualizar(Long id, Time time) {
        Optional<Time> t = timeRepository.findById(id);
        if(t.isPresent()) {
            time.setId(id);
            return timeRepository.save(time);
        }
        return null;
    }

    public void deletar(Long id) { timeRepository.deleteById(id); }

    public Time buscarPorNome(String nome) { return timeRepository.findByNome(nome).orElse(null); }
}
