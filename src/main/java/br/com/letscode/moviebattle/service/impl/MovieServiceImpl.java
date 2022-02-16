package br.com.letscode.moviebattle.service.impl;

import br.com.letscode.moviebattle.entities.Movie;
import br.com.letscode.moviebattle.repository.MovieRepository;
import br.com.letscode.moviebattle.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieData;
    private final ImdbWebScrapping webScrapping;

    public MovieServiceImpl(MovieRepository movieData, ImdbWebScrapping webScrapping) {
        this.movieData = movieData;
        this.webScrapping = webScrapping;
    }

    @Override
    public void saveMovies() {
        var moviesEntites = webScrapping.getMoviesFromWebScrapping();
        moviesEntites.forEach(movieData::save);
    }

    @Override
    public List<Movie> getTwoRandomMovies() {
        if (movieData.findAll().isEmpty()) {
            saveMovies();
        }

        List<Movie> movies = new ArrayList<>();
        var allMovies = movieData.findAll();
        var firstRandomNumber = allMovies.get(new Random().nextInt(40));
        var secondRandomNumber =  allMovies.get(new Random().nextInt(40));
        if (allMovies.size() > 2) {
            movies.add(0, firstRandomNumber);
            movies.add(1, secondRandomNumber);
        }

        if (!Objects.equals(movies.get(0).getId(), movies.get(1).getId())) {
            return movies;
        } else {
            return getTwoRandomMovies();
        }

    }
}
