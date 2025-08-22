package org.example.controller;

import org.example.domain.Campeonato;
import org.example.domain.Time;
import org.example.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;

    @PostMapping
    public Campeonato criar(@RequestBody Campeonato campeonato) {
        return campeonatoService.criar(campeonato);
    }

    @GetMapping
    public List<Campeonato> listarTodos() {
        return campeonatoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Campeonato buscarPorId(@PathVariable Long id) {
        return campeonatoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Campeonato atualizar(@PathVariable Long id, @RequestBody Campeonato campeonato) {
        return campeonatoService.atualizar(id, campeonato);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        campeonatoService.deletar(id);
    }

    @GetMapping("/times/{nome}")
    public List<Time> buscarTimesDoCampeonato(@PathVariable String nome) {
        return campeonatoService.buscarTimesDoCampeonato(nome);
    }
}
