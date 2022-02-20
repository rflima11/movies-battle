package br.com.letscode.moviebattle.service;

import br.com.letscode.moviebattle.entities.Jogo;
import br.com.letscode.moviebattle.entities.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getTwoRandomMovies(Jogo jogo);

}

