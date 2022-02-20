package br.com.letscode.moviebattle.service;

import br.com.letscode.moviebattle.entities.Rodada;
import br.com.letscode.moviebattle.entities.Usuario;

public interface RodadasService {

    Rodada inicializarRodada(Usuario usuario);

    String jogar(int numeroFilme);

}