package org.example.service;

import org.example.domain.Tecnico;
import org.example.domain.Time;
import org.example.repository.TecnicoRepository;
import org.example.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private TimeRepository timeRepository;

    public Tecnico criar(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    public Tecnico buscarPorId(Long id) {
        return tecnicoRepository.findById(id).orElse(null);
    }

    public Tecnico atualizar(Long id, Tecnico tecnico) {
        Optional<Tecnico> t = tecnicoRepository.findById(id);
        if(t.isPresent()) {
            tecnico.setId(id);
            return tecnicoRepository.save(tecnico);
        }
        return null;
    }

    public void deletar(Long id) {
        tecnicoRepository.deleteById(id);
    }

    public Time buscarTimeDoTecnico(String nomeTecnico) {
        Optional<Tecnico> t = tecnicoRepository.findByNome(nomeTecnico);
        return t.map(Tecnico::getTime).orElse(null);
    }
}
