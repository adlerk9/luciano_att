package org.example.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "times")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<Jogador> jogadores;

    @OneToOne(mappedBy = "time", cascade = CascadeType.ALL)
    private Tecnico tecnico;

    @ManyToMany
    @JoinTable(
            name = "time_campeonato",
            joinColumns = @JoinColumn(name = "time_id"),
            inverseJoinColumns = @JoinColumn(name = "campeonato_id")
    )
    private List<Campeonato> campeonatos;

    public Time() {}

    public Time(String nome, List<Jogador> jogadores, Tecnico tecnico, List<Campeonato> campeonatos) {
        this.nome = nome;
        this.jogadores = jogadores;
        this.tecnico = tecnico;
        this.campeonatos = campeonatos;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Jogador> getJogadores() { return jogadores; }
    public void setJogadores(List<Jogador> jogadores) { this.jogadores = jogadores; }

    public Tecnico getTecnico() { return tecnico; }
    public void setTecnico(Tecnico tecnico) { this.tecnico = tecnico; }

    public List<Campeonato> getCampeonatos() { return campeonatos; }
    public void setCampeonatos(List<Campeonato> campeonatos) { this.campeonatos = campeonatos; }
}
