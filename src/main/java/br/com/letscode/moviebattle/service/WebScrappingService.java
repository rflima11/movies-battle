package br.com.letscode.moviebattle.service;

import br.com.letscode.moviebattle.entities.Movie;

import java.util.List;

public interface WebScrappingService {

    List<Movie> getMoviesFromWebScrapping();

}
