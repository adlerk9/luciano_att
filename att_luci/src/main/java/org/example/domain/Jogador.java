package org.example.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "jogadores")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String posicao;
    private String status;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;

    public Jogador() {}

    public Jogador(String nome, String posicao, String status, Time time) {
        this.nome = nome;
        this.posicao = posicao;
        this.status = status;
        this.time = time;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPosicao() { return posicao; }
    public void setPosicao(String posicao) { this.posicao = posicao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }
}
