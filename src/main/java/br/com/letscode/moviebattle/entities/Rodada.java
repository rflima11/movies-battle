package br.com.letscode.moviebattle.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Rodada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private final String message;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Usuario usuario;
    private List<Movie> movies = new ArrayList<>();

    public Rodada(String message, List<Movie> movies) {
        this.message = message;
        this.movies = movies;
    }

    public boolean verificarResposta(int numeroFilme) {
        if (Objects.nonNull(numeroFilme)) {
            if (Objects.equals(numeroFilme, 1)) {
                return movies.get(0).getRating() > movies.get(1).getRating();
            } else {
                return movies.get(1).getRating() > movies.get(0).getRating();
            }
        }
        throw new RuntimeException("Você só pode escolher entre o filme 1 e filme 2");
    }

    public String getMessage() {
        return message;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
