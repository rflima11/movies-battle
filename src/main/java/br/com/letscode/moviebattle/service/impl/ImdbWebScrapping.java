package br.com.letscode.moviebattle.service.impl;

import br.com.letscode.moviebattle.entities.Movie;
import br.com.letscode.moviebattle.service.WebScrappingService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ImdbWebScrapping implements WebScrappingService {

    @Override
    public List<Movie> getMoviesFromWebScrapping() {
        try {
            var document = Jsoup.connect("https://www.imdb.com/list/ls505084004/?ref_=rltls_1").get();
            var titulos = document.getElementsByAttributeValueEnding("href", "tt")
                    .stream()
                    .map(e -> e.text())
                    .collect(Collectors.toList());
            var rating = document.getElementsByClass("ipl-rating-widget")
                    .stream()
                    .map(e -> (Element) e.childNode(1).childNode(3))
                    .map(e -> Double.parseDouble(e.text()))
                    .collect(Collectors.toList());

            return instanciarFilmes(titulos, rating);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível recuperar a lista de filmes");
        }

    }

    private List<Movie> instanciarFilmes(List<String> titles, List<Double> ratings) {
        List<Movie> listFilmes = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            listFilmes.add(new Movie(titles.get(i), ratings.get(i)));
        }
        return listFilmes;
    }

}
