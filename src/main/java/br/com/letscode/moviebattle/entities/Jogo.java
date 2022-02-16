package br.com.letscode.moviebattle.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private int erros;
    private Long score;
    @OneToMany(mappedBy = "usuario")
    private List<Rodada> rodadas;
    @JsonIgnore
    private boolean isFinalizado;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Jogo(Usuario usuario) {
        this.usuario = usuario;
        this.isFinalizado = false;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Long getScore() {
        return score;
    }

    public int getErros() {
        return erros;
    }

    public void setErros(int erros) {
        this.erros = erros;
    }

    public List<Rodada> getRodadas() {
        return rodadas;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}
