package br.com.letscode.moviebattle.service.impl;

import br.com.letscode.moviebattle.entities.Jogo;
import br.com.letscode.moviebattle.entities.Movie;
import br.com.letscode.moviebattle.repository.MovieRepository;
import br.com.letscode.moviebattle.service.MovieService;
import br.com.letscode.moviebattle.service.WebScrappingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieData;

    public MovieServiceImpl(MovieRepository movieData) {
        this.movieData = movieData;
    }

    /**
     * @param jogo: Jogo na qual será selecionado uma nova rodada, com dois filmes aleatórios.
     * @return: Retorna dois filmes aleatórios, sem repetição e com o rating diferente. Obs: perdão por esse método, tenho certeza que poderia
     * ter feito melhor, mas infelizmente fiquei sem tempo.
     */
    @Override
    public List<Movie> getTwoRandomMovies(Jogo jogo) {
        List<Movie> filmesRodadaAtual = new ArrayList<>();
        var allMovies = movieData.findAll();
        var primeiroFilme = allMovies.get(new Random().nextInt(allMovies.size() - 1));
        var segundoFilme = allMovies.get(new Random().nextInt(allMovies.size() - 1));
        if (allMovies.size() > 2 && !Objects.equals(primeiroFilme.getRating(), segundoFilme.getRating())) {
            filmesRodadaAtual.add(0, primeiroFilme);
            filmesRodadaAtual.add(1, segundoFilme);
            if (!Objects.equals(filmesRodadaAtual.get(0).getId(), filmesRodadaAtual.get(1).getId()) && !verificarSeFilmesEstaoRepetidos(filmesRodadaAtual, jogo)) {
                filmesRodadaAtual.get(0).setOpcao(1);
                filmesRodadaAtual.get(1).setOpcao(2);
                return filmesRodadaAtual;
            }
        }
        return getTwoRandomMovies(jogo);
    }


    /**
     * @param filmesRodadaAtual: Filmes que serão jogados essa rodada.
     * @param jogo: Jogo na qual será selecionado uma nova rodada, com dois filmes aleatórios.
     * @return: Retorna true caso haja filmes repetidos que já foram jogados, tanto na primera quanto na segunda posição.
     */
    private boolean verificarSeFilmesEstaoRepetidos(List<Movie> filmesRodadaAtual, Jogo jogo) {
        var rodadasPassadas = jogo.getRodadas();
        return rodadasPassadas.stream().anyMatch(rodada -> {
            var filmesRodadaPassadas = rodada.getMovies();
            var primeiroFilmeRodadaPassada = filmesRodadaPassadas.get(0);
            var segundoFilmeRodadaPassada = filmesRodadaPassadas.get(1);
            var primeiroFilmeRodadaAtual = filmesRodadaAtual.get(0);
            var segundoFilmeRodadaAtual = filmesRodadaAtual.get(1);
            return primeiroFilmeRodadaAtual == primeiroFilmeRodadaPassada && segundoFilmeRodadaAtual == segundoFilmeRodadaPassada
                    || primeiroFilmeRodadaAtual == segundoFilmeRodadaPassada && segundoFilmeRodadaAtual == primeiroFilmeRodadaPassada;
        });
    }
}
