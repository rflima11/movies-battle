package br.com.letscode.moviebattle.service;

import br.com.letscode.moviebattle.entities.Jogo;

import java.util.Optional;

public interface JogoService {

    void inicializarJogo();

    Jogo findJogoByUsuario();

    String finalizarJogo(Jogo jogo);

}
