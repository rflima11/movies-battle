package br.com.letscode.moviebattle.service.impl;

import br.com.letscode.moviebattle.entities.Rodada;
import br.com.letscode.moviebattle.entities.Usuario;
import br.com.letscode.moviebattle.service.MovieService;
import br.com.letscode.moviebattle.service.RodadasService;
import br.com.letscode.moviebattle.utils.ConstantesUtils;
import org.springframework.stereotype.Service;

@Service
public class RodadasServiceImpl implements RodadasService {

    private final MovieService movieService;

    public RodadasServiceImpl(MovieService moviePort) {
        this.movieService = moviePort;
    }

    @Override
    public Rodada incializarRodada() {
        return new Rodada(ConstantesUtils.getMensagemRodada(new Usuario()), movieService.getTwoRandomMovies());
    }
}
