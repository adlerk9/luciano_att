package org.example.controller;

import org.example.domain.Jogador;
import org.example.domain.Time;
import org.example.service.JogadorService;
import org.example.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @Autowired
    private TimeService timeService;

    @PostMapping
    public Jogador criar(@RequestBody Jogador jogador) {
        return jogadorService.criar(jogador);
    }

    @GetMapping
    public List<Jogador> listarTodos() {
        return jogadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Jogador buscarPorId(@PathVariable Long id) {
        return jogadorService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Jogador atualizar(@PathVariable Long id, @RequestBody Jogador jogador) {
        return jogadorService.atualizar(id, jogador);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        jogadorService.deletar(id);
    }

    @GetMapping("/nome/{nome}")
    public Jogador buscarPorNome(@PathVariable String nome) {
        return jogadorService.buscarPorNome(nome);
    }

    @GetMapping("/status/{status}")
    public List<Jogador> buscarPorStatus(@PathVariable String status) {
        return jogadorService.buscarPorStatus(status);
    }

    @GetMapping("/time/{nomeTime}")
    public List<Jogador> buscarPorTime(@PathVariable String nomeTime) {
        return jogadorService.buscarPorTime(nomeTime);
    }
}
