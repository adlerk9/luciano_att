package org.example.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tecnicos")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne
    @JoinColumn(name = "time_id")
    private Time time;

    public Tecnico() {}

    public Tecnico(String nome, Time time) {
        this.nome = nome;
        this.time = time;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }
}
