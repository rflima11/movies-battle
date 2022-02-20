package br.com.letscode.moviebattle.service;

import br.com.letscode.moviebattle.entities.Jogo;

public interface JogoService {

    void inicializarJogo();

    Jogo findJogoByUsuario();

    String finalizarJogo(Jogo jogo);

}
