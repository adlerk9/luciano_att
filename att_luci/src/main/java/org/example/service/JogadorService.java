package org.example.service;

import org.example.domain.Jogador;
import org.example.domain.Time;
import org.example.repository.JogadorRepository;
import org.example.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private TimeRepository timeRepository;

    public Jogador criar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.findAll();
    }

    public Jogador buscarPorId(Long id) {
        return jogadorRepository.findById(id).orElse(null);
    }

    public Jogador atualizar(Long id, Jogador jogador) {
        Optional<Jogador> j = jogadorRepository.findById(id);
        if(j.isPresent()) {
            jogador.setId(id);
            return jogadorRepository.save(jogador);
        }
        return null;
    }

    public void deletar(Long id) {
        jogadorRepository.deleteById(id);
    }

    public Jogador buscarPorNome(String nome) {
        return jogadorRepository.findByNome(nome).orElse(null);
    }

    public List<Jogador> buscarPorStatus(String status) {
        return jogadorRepository.findByStatus(status);
    }

    public List<Jogador> buscarPorTime(String nomeTime) {
        Optional<Time> time = timeRepository.findByNome(nomeTime);
        return time.map(jogadorRepository::findByTime).orElse(null);
    }
}
