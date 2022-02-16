package br.com.letscode.moviebattle.utils;

import br.com.letscode.moviebattle.entities.Usuario;

public class ConstantesUtils {

    public static final String getMensagemRodada(Usuario usuario) {
        return  usuario.getNome().concat(" deve escolher entre os dois filmes, qual deles você acha que tem a maior pontuação? Filme 1 ou Filme 2?");
    }

}
