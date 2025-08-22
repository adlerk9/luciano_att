package org.example.controller;

import org.example.domain.Time;
import org.example.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @PostMapping
    public Time criar(@RequestBody Time time) { return timeService.criar(time); }

    @GetMapping
    public List<Time> listarTodos() { return timeService.listarTodos(); }

    @GetMapping("/{id}")
    public Time buscarPorId(@PathVariable Long id) { return timeService.buscarPorId(id); }

    @PutMapping("/{id}")
    public Time atualizar(@PathVariable Long id, @RequestBody Time time) { return timeService.atualizar(id, time); }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { timeService.deletar(id); }

    @GetMapping("/nome/{nome}")
    public Time buscarPorNome(@PathVariable String nome) { return timeService.buscarPorNome(nome); }
}
