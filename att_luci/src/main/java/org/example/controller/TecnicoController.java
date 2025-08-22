package org.example.controller;

import org.example.domain.Tecnico;
import org.example.domain.Time;
import org.example.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @PostMapping
    public Tecnico criar(@RequestBody Tecnico tecnico) {
        return tecnicoService.criar(tecnico);
    }

    @GetMapping("/{id}")
    public Tecnico buscarPorId(@PathVariable Long id) {
        return tecnicoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Tecnico atualizar(@PathVariable Long id, @RequestBody Tecnico tecnico) {
        return tecnicoService.atualizar(id, tecnico);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        tecnicoService.deletar(id);
    }

    @GetMapping("/time/{nomeTecnico}")
    public Time buscarTimeDoTecnico(@PathVariable String nomeTecnico) {
        return tecnicoService.buscarTimeDoTecnico(nomeTecnico);
    }
}
