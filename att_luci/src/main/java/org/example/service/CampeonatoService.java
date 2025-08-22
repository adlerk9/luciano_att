package org.example.service;

import org.example.domain.Campeonato;
import org.example.domain.Time;
import org.example.repository.CampeonatoRepository;
import org.example.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @Autowired
    private TimeRepository timeRepository;

    public Campeonato criar(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    public List<Campeonato> listarTodos() {
        return campeonatoRepository.findAll();
    }

    public Campeonato buscarPorId(Long id) {
        return campeonatoRepository.findById(id).orElse(null);
    }

    public Campeonato atualizar(Long id, Campeonato campeonato) {
        Optional<Campeonato> c = campeonatoRepository.findById(id);
        if(c.isPresent()) {
            campeonato.setId(id);
            return campeonatoRepository.save(campeonato);
        }
        return null;
    }

    public void deletar(Long id) {
        campeonatoRepository.deleteById(id);
    }

    public List<Time> buscarTimesDoCampeonato(String nome) {
        Optional<Campeonato> c = campeonatoRepository.findByNome(nome);
        return c.map(Campeonato::getTimes).orElse(null);
    }
}
