package br.com.letscode.moviebattle.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    private Double scoreAtual;
    private Double melhorScore;
    @OneToMany(mappedBy = "usuario")
    private List<Jogo> jogos;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getScoreAtual() {
        return scoreAtual;
    }

    public void setScoreAtual(Double scoreAtual) {
        this.scoreAtual = scoreAtual;
    }

    public Double getMelhorScore() {
        return melhorScore;
    }

    public void setMelhorScore(Double melhorScore) {
        this.melhorScore = melhorScore;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
}
